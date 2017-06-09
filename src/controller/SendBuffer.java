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
 *
 * @author Łukasz Wojtas
 */
public class SendBuffer {

    private static List<Window> windowList = new ArrayList<>();
    private static List<KeyboardClick> keyboardClickList = new ArrayList<>();
    private static List<MouseClick> mouseClickList = new ArrayList<>();
    private static List<MouseScroll> mouseScrollList = new ArrayList<>();

    public static void addWindow(Window window) {
        windowList.add(window);
    }

    public static void addWindowList(List<Window> windowList) {
        SendBuffer.windowList.addAll(windowList);
    }

    public static void addKeyboardClick(KeyboardClick keyboardClick) {
        keyboardClickList.add(keyboardClick);
    }

    public static void addKeyboardClickList(List<KeyboardClick> keyboardClickList) {
        SendBuffer.keyboardClickList.addAll(keyboardClickList);
    }

    public static void addMouseClick(MouseClick mouseClick) {
        mouseClickList.add(mouseClick);
    }

    public static void addMouseClickList(List<MouseClick> mouseClickList) {
        SendBuffer.mouseClickList.addAll(mouseClickList);
    }

    public static void addMouseScroll(MouseScroll mouseScroll) {
        mouseScrollList.add(mouseScroll);
    }

    public static void addMouseScrollList(List<MouseScroll> mouseScrollList) {
        SendBuffer.mouseScrollList.addAll(mouseScrollList);
    }

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
