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
 *
 * @author Łukasz Wojtas
 */
public class WindowService {

    private static WindowDAO windowDAO = new WindowDAO();

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
