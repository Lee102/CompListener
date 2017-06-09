/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.KeyboardClick;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Łukasz Wojtas
 */
public class KeyListener implements NativeKeyListener {

    private List<KeyboardClick> keyboardClickList;

    public KeyListener() {
        keyboardClickList = new ArrayList<>();
    }

    public List<KeyboardClick> releaseKeyboardClickList() {
        List<KeyboardClick> list = this.keyboardClickList;
        this.keyboardClickList = new ArrayList<>();
        return list;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        //Dodanie nowego kliknięcia do listy
        KeyboardClick keyboardClick = new KeyboardClick();
        keyboardClick.setKeyText(NativeKeyEvent.getKeyText(e.getKeyCode()));
        keyboardClick.setTime(Calendar.getInstance().getTime());
        keyboardClickList.add(keyboardClick);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    public List<KeyboardClick> getKeyboardClickList() {
        return keyboardClickList;
    }

    public void setKeyboardClickList(List<KeyboardClick> keyboardClickList) {
        this.keyboardClickList = keyboardClickList;
    }

}
