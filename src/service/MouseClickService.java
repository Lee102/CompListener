/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.SendBuffer;
import dao.MouseClickDAO;
import entity.MouseClick;
import java.util.List;

/**
 * Service klasy MouseClickDAO.
 *
 * @see MouseClickDAO {@link MouseClickDAO}
 * @author Łukasz Wojtas
 */
public class MouseClickService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy MouseClickDAO.
     */
    private static MouseClickDAO mouseClickDAO = new MouseClickDAO();

    /**
     * Wywołanie metody save() klasy MouseClickDAO oraz zarządanie sesją i
     * transakcją.
     *
     * @param mouseClick Parametr do metody klasy MouseClickDAO.
     */
    public static void save(MouseClick mouseClick) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            mouseClickDAO.setTransaction(SessionTransaction.openTransaction(mouseClickDAO.getSession()));
            mouseClickDAO.save(mouseClick);
            SessionTransaction.closeTransaction(mouseClickDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addMouseClick(mouseClick);
        }
    }

    /**
     * Wywołanie metody saveList() klasy MouseClickDAO oraz zarządanie sesją i
     * transakcją.
     *
     * @param mouseClickList Parametr do metody klasy MouseClickDAO.
     */
    public static void saveList(List<MouseClick> mouseClickList) {
        try {
            mouseClickDAO.setSession(SessionTransaction.openSession());
            mouseClickDAO.setTransaction(SessionTransaction.openTransaction(mouseClickDAO.getSession()));
            mouseClickDAO.saveList(mouseClickList);
            SessionTransaction.closeTransaction(mouseClickDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addMouseClickList(mouseClickList);
        }
    }

}
