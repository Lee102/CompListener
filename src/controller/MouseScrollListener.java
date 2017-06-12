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
 * Klasa używana do zbierania danych o użyciach przez użytkownika kółka myszki.
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollListener implements NativeMouseWheelListener {

    /**
     * Prywatna lista obiektów MouseScroll. Zawiera dane o wszystkich użyciach
     * kółka myszki dla bieżącego okna.
     */
    private List<MouseScroll> mouseScrollList;

    /**
     * Konstruktor. Inicjalizuje listę mouseScrollList.
     */
    public MouseScrollListener() {
        mouseScrollList = new ArrayList<>();
    }

    /**
     * Zwrócenie listy mouseScrollList. Używane w momencie zmiany wybranego okna
     * do zwrócenia wszystkich dotychczasowych danych i stworzenia nowej, pustej
     * listy.
     *
     * @return Lista obiektów MouseScroll.
     */
    public List<MouseScroll> releaseMouseWheelMoveList() {
        List<MouseScroll> mouseScrollList = this.mouseScrollList;
        this.mouseScrollList = new ArrayList<>();
        return mouseScrollList;
    }

    /**
     * Metoda wywoływana podczas poruszenia kółkiem myszki. Dodaje nowy element
     * do listy mouseScrollList.
     *
     * @param e Dane poruszenia kółkiem myszki.
     */
    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        //Dodanie nowego poruszenia kółkiem myszki do listy
        MouseScroll mouseScroll = new MouseScroll();
        mouseScroll.setDirection(e.getWheelRotation());
        mouseScroll.setTime(Calendar.getInstance().getTime());
        mouseScrollList.add(mouseScroll);
    }

    /**
     * Getter pola mouseScrollList.
     *
     * @return Wartość pola mouseScrollList.
     */
    public List<MouseScroll> getMouseScrollList() {
        return mouseScrollList;
    }

    /**
     * Setter pola mouseScrollList.
     *
     * @param mouseScrollList Wartość do zapisania do pola mouseScrollList.
     */
    public void setMouseScrollList(List<MouseScroll> mouseScrollList) {
        this.mouseScrollList = mouseScrollList;
    }

}
