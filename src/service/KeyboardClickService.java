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
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickService {

    private static KeyboardClickDAO keyboardClickDAO = new KeyboardClickDAO();

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
