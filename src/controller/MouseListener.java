/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.MouseClick;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 *
 * @author Łukasz Wojtas
 */
public class MouseListener implements NativeMouseInputListener {

    private List<MouseClick> mouseClickList;

    public MouseListener() {
        mouseClickList = new ArrayList<>();
    }

    public List<MouseClick> releaseMouseClickList() {
        List<MouseClick> mouseClickList = this.mouseClickList;
        this.mouseClickList = new ArrayList<>();
        return mouseClickList;
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        //Dodanie nowego kliknięcia myszką do listy
        MouseClick mouseClick = new MouseClick();
        mouseClick.setButton(e.getButton());
        mouseClick.setX(e.getX());
        mouseClick.setY(e.getY());
        mouseClick.setTime(Calendar.getInstance().getTime());
        mouseClickList.add(mouseClick);
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
    }

    public List<MouseClick> getMouseClickList() {
        return mouseClickList;
    }

    public void setMouseClickList(List<MouseClick> mouseClickList) {
        this.mouseClickList = mouseClickList;
    }

}
