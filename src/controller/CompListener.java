/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import entity.KeyboardClick;
import entity.MouseClick;
import entity.MouseScroll;
import entity.Window;
import entity.Workstation;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * Główna klasa programu.
 *
 * @author Łukasz Wojtas
 */
public class CompListener {

    /**
     * Prywatne, statyczne pole klasy KeyListener.
     */
    private static KeyListener keyListener = new KeyListener();

    /**
     * Prywatne, statyczne pole klasy MouseListener.
     */
    private static MouseListener mouseListener = new MouseListener();

    /**
     * Prywatne, statyczne pole klasy MouseScrollListener.
     */
    private static MouseScrollListener mouseScrollListener = new MouseScrollListener();

    /**
     * Prywatne, statyczne pole klasy Workstation. Przechowuje informacje o
     * stacji roboczej na któej uruchomiony jest program.
     */
    private static Workstation workstation;

    /**
     * Prywatne, statyczne pole klasy Window. Przechowuje informacje o aktualnie
     * otwartym oknie.
     */
    private static Window window;

    /**
     * Prywatne, statyczne pole typu int. Zawiera informacje o bieżącym trybie
     * działania programu. 0 oznacza sparowanie pola workstation z bazą danych.
     * 1 oznacza brak sparowania.
     */
    private static int mode;

    /**
     * Prywatne, statyczne pole typu int. Zmiania wartości na 1 oznacza że
     * program ma zostać wyłączony.
     */
    private static int end = 0;

    /**
     * Metoda main. Wywołuje metodę otwierającą ikonę w System Tray. Rejestruje
     * obiekt NativeHook w systemie. Dodaje kolejne obiekty listenerów.
     * Uruchamia sparowanie workstation z bazą danych i rozpoczyna zbieranie
     * danych metodą checkWindowFocus().
     *
     * @param args Argumenty linii poleceń.
     */
    public static void main(String[] args) {
        TrayIcon.trayIcon();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("Error while registering the native hook");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(keyListener);
        GlobalScreen.addNativeMouseListener(mouseListener);
        GlobalScreen.addNativeMouseMotionListener(mouseListener);
        GlobalScreen.addNativeMouseWheelListener(mouseScrollListener);

        mode = WorkstationInfo.sendWorkstation();
        workstation = WorkstationInfo.getWorkstation();
        checkWindowFocus();
        sendData();
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            System.err.println(e);
        }
        System.exit(0);
    }

    /**
     * Znalezienie okna które jest obecnie wybrane. Jeżeli okno to się zmieni
     * (jest inne niż poprzednie) wysyłane są dotychczas zebrane dane (metoda
     * sendData()), a dla nowego okna robiony zrzut ekranu (metoda snapShot(...)
     * klasy ScreenCapture).
     */
    private static void checkWindowFocus() {
        char[] buffer = new char[2048];
        WinDef.HWND hwnd;
        WinDef.RECT rect = new WinDef.RECT();
        String cT, pT;

        do {
            hwnd = User32.INSTANCE.GetForegroundWindow();
            User32.INSTANCE.GetWindowText(hwnd, buffer, 1024);
            pT = Native.toString(buffer);
            User32.INSTANCE.GetWindowRect(hwnd, rect);
        } while (hwnd == null || pT.compareTo("") == 0);
        ScreenCapture.snapShot(rect);

        window = new Window();
        window.setStartDate(Calendar.getInstance().getTime());
        window.setWindowTitle(pT);
        window.setFirstWindow(Short.valueOf("1"));

        while (end == 0) {
            hwnd = User32.INSTANCE.GetForegroundWindow();
            if (hwnd != null) {
                User32.INSTANCE.GetWindowText(hwnd, buffer, 1024);
                cT = Native.toString(buffer);
                if (cT.compareTo("") != 0 && cT.equals(pT) == false) {
                    if (mode == 1) {
                        mode = WorkstationInfo.sendWorkstation();
                    }
                    sendData();
                    User32.INSTANCE.GetWindowRect(hwnd, rect);
                    window = new Window();
                    window.setStartDate(Calendar.getInstance().getTime());
                    window.setWindowTitle(cT);
                    window.setFirstWindow(Short.valueOf("0"));
                    ScreenCapture.snapShot(rect);
                    pT = cT;
                }
            }
        }
    }

    /**
     * Zebranie i umieszczenie w buforze danych (SendBuffer) dotyczących
     * poprzedniego okna.
     */
    public static void sendData() {
        List<KeyboardClick> keyboardClickList = keyListener.releaseKeyboardClickList();
        List<MouseClick> mouseClickList = mouseListener.releaseMouseClickList();
        List<MouseScroll> mouseScrollList = mouseScrollListener.releaseMouseWheelMoveList();
        window.setPrintScreen(ScreenCapture.getPrintScreen());

        window.setWorkstationId(workstation);
        keyboardClickList.forEach((keyboardClick) -> {
            keyboardClick.setWindowId(window);
        });
        mouseClickList.forEach((mouseClick) -> {
            mouseClick.setWindowId(window);
        });
        mouseScrollList.forEach((mouseScroll) -> {
            mouseScroll.setWindowId(window);
        });

        SendBuffer.addWindow(window);
        if (!keyboardClickList.isEmpty()) {
            SendBuffer.addKeyboardClickList(keyboardClickList);
        }
        if (!mouseClickList.isEmpty()) {
            SendBuffer.addMouseClickList(mouseClickList);
        }
        if (!mouseScrollList.isEmpty()) {
            SendBuffer.addMouseScrollList(mouseScrollList);
        }
        if (mode == 0) {
            SendBuffer.sendBuffer();
        }
    }

    /**
     * Setter pola end.
     *
     * @param end Wartość do zapisania do pola end.
     */
    public static void setEnd(int end) {
        CompListener.end = end;
    }
}
