/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.SendBuffer;
import dao.WindowDAO;
import entity.Window;
import java.util.List;

/**
 * Service klasy WindowDAO.
 *
 * @see WindowDAO {@link WindowDAO}
 * @author Łukasz Wojtas
 */
public class WindowService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy WindowDAO.
     */
    private static WindowDAO windowDAO = new WindowDAO();

    /**
     * Wywołanie metody save() klasy WindowDAO oraz zarządanie sesją i
     * transakcją.
     *
     * @param window Parametr do metody klasy WindowDAO.
     */
    public static void save(Window window) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            windowDAO.setTransaction(SessionTransaction.openTransaction(windowDAO.getSession()));
            windowDAO.save(window);
            SessionTransaction.closeTransaction(windowDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addWindow(window);
        }
    }

    /**
     * Wywołanie metody saveList() klasy WindowDAO oraz zarządanie sesją i
     * transakcją.
     *
     * @param windowList Parametr do metody klasy WindowDAO.
     */
    public static void saveList(List<Window> windowList) {
        try {
            windowDAO.setSession(SessionTransaction.openSession());
            windowDAO.setTransaction(SessionTransaction.openTransaction(windowDAO.getSession()));
            windowDAO.saveList(windowList);
            SessionTransaction.closeTransaction(windowDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addWindowList(windowList);
        }
    }

}
