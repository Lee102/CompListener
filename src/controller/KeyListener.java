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
 * Klasa używana do zbierania danych o naciśniętych przez użytkownika
 * klawiszach.
 *
 * @author Łukasz Wojtas
 */
public class KeyListener implements NativeKeyListener {

    /**
     * Prywatna lista obiektów KeyboardClick. Zawiera dane o wszystkich
     * naciśnięciach na klawiaturze dla bieżącego okna.
     */
    private List<KeyboardClick> keyboardClickList;

    /**
     * Konstruktor. Inicjalizuje listę keyboardClickList.
     */
    public KeyListener() {
        keyboardClickList = new ArrayList<>();
    }

    /**
     * Zwrócenie listy keyboardClickList. Używane w momencie zmiany wybranego
     * okna do zwrócenia wszystkich dotychczasowych danych i stworzenia nowej,
     * pustej listy.
     *
     * @return Lista obiektów KeyboardClick.
     */
    public List<KeyboardClick> releaseKeyboardClickList() {
        List<KeyboardClick> list = this.keyboardClickList;
        this.keyboardClickList = new ArrayList<>();
        return list;
    }

    /**
     * Metoda wywoływana podczas naciśnięcia przycisku na klawiaturze. Dodaje
     * nowy element do listy keyboardClickList.
     *
     * @param e Dane naciśniętego przycisku.
     */
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        KeyboardClick keyboardClick = new KeyboardClick();
        keyboardClick.setKeyText(NativeKeyEvent.getKeyText(e.getKeyCode()));
        keyboardClick.setTime(Calendar.getInstance().getTime());
        keyboardClickList.add(keyboardClick);
    }

    /**
     * Metoda wywoływana podczas zwolnienia przycisku na klawiaturze.
     * Nieużywana.
     *
     * @param e Dane zwolnionego przycisku.
     */
    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    /**
     * Metoda wywoływana podczas wpisania znaku. Nieużywana z powodu braku
     * odpowiednich map w bibliotece JNativeHook.
     *
     * @param e Dane wpisanego znaku.
     */
    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    /**
     * Getter pola keyboardClickList.
     *
     * @return Wartość pola keyboardClickList.
     */
    public List<KeyboardClick> getKeyboardClickList() {
        return keyboardClickList;
    }

    /**
     * Setter pola keyboardClickList.
     *
     * @param keyboardClickList Wartość do zapisania do pola keyboardClickList.
     */
    public void setKeyboardClickList(List<KeyboardClick> keyboardClickList) {
        this.keyboardClickList = keyboardClickList;
    }

}
