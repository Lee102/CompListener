/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.MouseScroll;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

/**
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollListener implements NativeMouseWheelListener {

    private List<MouseScroll> mouseScrollList;

    public MouseScrollListener() {
        mouseScrollList = new ArrayList<>();
    }

    public List<MouseScroll> releaseMouseWheelMoveList() {
        List<MouseScroll> mouseScrollList = this.mouseScrollList;
        this.mouseScrollList = new ArrayList<>();
        return mouseScrollList;
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        //Dodanie nowego poruszenia kółkiem myszki do listy
        MouseScroll mouseScroll = new MouseScroll();
        mouseScroll.setDirection(e.getWheelRotation());
        mouseScroll.setTime(Calendar.getInstance().getTime());
        mouseScrollList.add(mouseScroll);
    }

    public List<MouseScroll> getMouseScrollList() {
        return mouseScrollList;
    }

    public void setMouseScrollList(List<MouseScroll> mouseScrollList) {
        this.mouseScrollList = mouseScrollList;
    }

}
