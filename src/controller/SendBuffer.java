/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.KeyboardClick;
import entity.MouseClick;
import entity.MouseScroll;
import entity.Window;
import java.util.ArrayList;
import java.util.List;
import service.KeyboardClickService;
import service.MouseClickService;
import service.MouseScrollService;
import service.WindowService;

/**
 * Klasa używana jako bufor przesyłu danych na serwer. Tak długo jak niemopżliwe
 * jest wysłanie danych na serwer dane są gromadzone. W momencie uzyskania
 * połączenia następuje ich wysłanie.
 *
 * @author Łukasz Wojtas
 */
public class SendBuffer {

    /**
     * Prywatna, statyczna lista obiektów Window.
     */
    private static List<Window> windowList = new ArrayList<>();
    /**
     * Prywatna, statyczna lista obiektów KeyboardClick.
     */
    private static List<KeyboardClick> keyboardClickList = new ArrayList<>();
    /**
     * Prywatna, statyczna lista obiektów MouseClick.
     */
    private static List<MouseClick> mouseClickList = new ArrayList<>();
    /**
     * Prywatna, statyczna lista obiektów MouseScroll.
     */
    private static List<MouseScroll> mouseScrollList = new ArrayList<>();

    /**
     * Dodanie obiektu do listy windowList.
     *
     * @param window Obiekt Window.
     */
    public static void addWindow(Window window) {
        windowList.add(window);
    }

    /**
     * Dodanie listy obiektów do listy windowList.
     *
     * @param windowList Lista obiektów Window.
     */
    public static void addWindowList(List<Window> windowList) {
        SendBuffer.windowList.addAll(windowList);
    }

    /**
     * Dodanie obiektu do listy keyboardClickList.
     *
     * @param keyboardClick Obiekt KeyboardClick.
     */
    public static void addKeyboardClick(KeyboardClick keyboardClick) {
        keyboardClickList.add(keyboardClick);
    }

    /**
     * Dodanie listy obiektów do listy keyboardClickList.
     *
     * @param keyboardClickList Lista obiektów KeyboardClick.
     */
    public static void addKeyboardClickList(List<KeyboardClick> keyboardClickList) {
        SendBuffer.keyboardClickList.addAll(keyboardClickList);
    }

    /**
     * Dodanie obiektu do listy mouseClickList.
     *
     * @param mouseClick Obiekt MouseClick.
     */
    public static void addMouseClick(MouseClick mouseClick) {
        mouseClickList.add(mouseClick);
    }

    /**
     * Dodanie listy obiektów do listy mouseClickList.
     *
     * @param mouseClickList Lista obiektów MouseClick.
     */
    public static void addMouseClickList(List<MouseClick> mouseClickList) {
        SendBuffer.mouseClickList.addAll(mouseClickList);
    }

    /**
     * Dodanie obiektu do listy mouseScrollList.
     *
     * @param mouseScroll Obiekt MouseScroll.
     */
    public static void addMouseScroll(MouseScroll mouseScroll) {
        mouseScrollList.add(mouseScroll);
    }

    /**
     * Dodanie listy obiektów do listy mouseScrollList.
     *
     * @param mouseScrollList Lista obiektów MouseScroll.
     */
    public static void addMouseScrollList(List<MouseScroll> mouseScrollList) {
        SendBuffer.mouseScrollList.addAll(mouseScrollList);
    }

    /**
     * Wysłanie danych z bufora na serwer.
     */
    public static void sendBuffer() {
        List<Window> windowList = SendBuffer.windowList;
        List<KeyboardClick> keyboardClickList = SendBuffer.keyboardClickList;
        List<MouseClick> mouseClickList = SendBuffer.mouseClickList;
        List<MouseScroll> mouseScrollList = SendBuffer.mouseScrollList;

        SendBuffer.windowList = new ArrayList<>();
        SendBuffer.keyboardClickList = new ArrayList<>();
        SendBuffer.mouseClickList = new ArrayList<>();
        SendBuffer.mouseScrollList = new ArrayList<>();

        try {
            if (!windowList.isEmpty()) {
                WindowService.saveList(windowList);
            }
            if (!keyboardClickList.isEmpty()) {
                KeyboardClickService.saveList(keyboardClickList);
            }
            if (!mouseClickList.isEmpty()) {
                MouseClickService.saveList(mouseClickList);
            }
            if (!mouseScrollList.isEmpty()) {
                MouseScrollService.saveList(mouseScrollList);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
