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
 * Klasa używana do zbierania danych o naciśniętych przez użytkownika
 * przyciskach myszki.
 *
 * @author Łukasz Wojtas
 */
public class MouseListener implements NativeMouseInputListener {

    /**
     * Prywatna lista obiektów MouseClick. Zawiera dane o wszystkich
     * naciśnięciach na myszce dla bieżącego okna.
     */
    private List<MouseClick> mouseClickList;

    /**
     * Konstruktor. Inicjalizuje listę mouseClickList.
     */
    public MouseListener() {
        mouseClickList = new ArrayList<>();
    }

    /**
     * Zwrócenie listy mouseClickList. Używane w momencie zmiany wybranego okna
     * do zwrócenia wszystkich dotychczasowych danych i stworzenia nowej, pustej
     * listy.
     *
     * @return Lista obiektów MouseClick.
     */
    public List<MouseClick> releaseMouseClickList() {
        List<MouseClick> mouseClickList = this.mouseClickList;
        this.mouseClickList = new ArrayList<>();
        return mouseClickList;
    }

    /**
     * Metoda wywoływana podczas naciśnięcia przycisku na myszce. Dodaje nowy
     * element do listy mouseClickList.
     *
     * @param e Dane naciśniętego przycisku.
     */
    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        MouseClick mouseClick = new MouseClick();
        mouseClick.setButton(e.getButton());
        mouseClick.setX(e.getX());
        mouseClick.setY(e.getY());
        mouseClick.setTime(Calendar.getInstance().getTime());
        mouseClickList.add(mouseClick);
    }

    /**
     * Metoda wywoływana podczas naciśnięcia przycisku na myszce. Nieużywana.
     *
     * @param e Dane naciśniętego przycisku.
     */
    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
    }

    /**
     * Metoda wywoływana podczas zwolnienia przycisku na myszce. Nieużywana.
     *
     * @param e Dane zwolnionego przycisku.
     */
    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
    }

    /**
     * Metoda wywoływana podczas poruszenia myszką. Nieużywana.
     *
     * @param e Dane poruszenia myszką.
     */
    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
    }

    /**
     * Metoda wywoływana podczas poruszenia myszką z jednocześnie wciśniętym
     * przyciskiem. Nieużywana.
     *
     * @param e Dane przeciągnięcia myszką.
     */
    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
    }

    /**
     * Getter pola mouseClickList.
     *
     * @return Wartość pola mouseClickList.
     */
    public List<MouseClick> getMouseClickList() {
        return mouseClickList;
    }

    /**
     * Setter pola mouseClickList.
     *
     * @param mouseClickList Wartość do zapisania do pola mouseClickList.
     */
    public void setMouseClickList(List<MouseClick> mouseClickList) {
        this.mouseClickList = mouseClickList;
    }

}
