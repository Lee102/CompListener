/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.SendBuffer;
import dao.KeyboardClickDAO;
import entity.KeyboardClick;
import java.util.List;

/**
 * Service klasy KeyboardClickDAO.
 *
 * @see KeyboardClickDAO {@link KeyboardClickDAO}
 * @author Łukasz Wojtas
 */
public class KeyboardClickService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy KeyboardClickDAO.
     */
    private static KeyboardClickDAO keyboardClickDAO = new KeyboardClickDAO();

    /**
     * Wywołanie metody save() klasy KeyboardClickDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param keyboardClick Parametr do metody klasy KeyboardClickDAO.
     */
    public static void save(KeyboardClick keyboardClick) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            keyboardClickDAO.setTransaction(SessionTransaction.openTransaction(keyboardClickDAO.getSession()));
            keyboardClickDAO.save(keyboardClick);
            SessionTransaction.closeTransaction(keyboardClickDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addKeyboardClick(keyboardClick);
        }
    }

    /**
     * Wywołanie metody saveList() klasy KeyboardClickDAO oraz zarządzanie sesją
     * i transakcją.
     *
     * @param keyboardClickList Parametr do metody klasy KeyboardClickDAO.
     */
    public static void saveList(List<KeyboardClick> keyboardClickList) {
        try {
            keyboardClickDAO.setSession(SessionTransaction.openSession());
            keyboardClickDAO.setTransaction(SessionTransaction.openTransaction(keyboardClickDAO.getSession()));
            keyboardClickDAO.saveList(keyboardClickList);
            SessionTransaction.closeTransaction(keyboardClickDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addKeyboardClickList(keyboardClickList);
        }
    }

}
