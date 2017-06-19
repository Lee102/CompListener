/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.SendBuffer;
import dao.MouseScrollDAO;
import entity.MouseScroll;
import java.util.List;

/**
 * Service klasy MouseScrollDAO.
 *
 * @see MouseScrollDAO {@link MouseScrollDAO}
 * @author Łukasz Wojtas
 */
public class MouseScrollService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy MouseScrollDAO.
     */
    private static MouseScrollDAO mouseScrollDAO = new MouseScrollDAO();

    /**
     * Wywołanie metody save() klasy MouseScrollDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param mouseScroll Parametr do metody klasy MouseScrollDAO.
     */
    public static void save(MouseScroll mouseScroll) {
        mouseScrollDAO.setSession(SessionTransaction.openSession());
        mouseScrollDAO.setTransaction(SessionTransaction.openTransaction(mouseScrollDAO.getSession()));
        mouseScrollDAO.save(mouseScroll);
        SessionTransaction.closeTransaction(mouseScrollDAO.getTransaction());
    }

    /**
     * Wywołanie metody saveList() klasy MouseScrollDAO oraz zarządzanie sesją i
     * transakcją.
     *
     * @param mouseScrollList Parametr do metody klasy MouseScrollDAO.
     */
    public static void saveList(List<MouseScroll> mouseScrollList) {
        mouseScrollDAO.setSession(SessionTransaction.openSession());
        mouseScrollDAO.setTransaction(SessionTransaction.openTransaction(mouseScrollDAO.getSession()));
        mouseScrollDAO.saveList(mouseScrollList);
        SessionTransaction.closeTransaction(mouseScrollDAO.getTransaction());
    }

}
