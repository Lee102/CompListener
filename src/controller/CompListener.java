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
 *
 * @author Łukasz Wojtas
 */
public class CompListener {

    private static KeyListener keyListener = new KeyListener();
    private static MouseListener mouseListener = new MouseListener();
    private static MouseScrollListener mouseScrollListener = new MouseScrollListener();
    private static Workstation workstation;
    private static Window window;
    private static int mode, end = 0;

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
                    //System.out.println("checkWindowFocus '" + pT + "' '" + cT + "'");
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

    public static void setEnd(int end) {
        CompListener.end = end;
    }
}
