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
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollService {

    private static MouseScrollDAO mouseScrollDAO = new MouseScrollDAO();

    public static void save(MouseScroll mouseScroll) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            mouseScrollDAO.setTransaction(SessionTransaction.openTransaction(mouseScrollDAO.getSession()));
            mouseScrollDAO.save(mouseScroll);
            SessionTransaction.closeTransaction(mouseScrollDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addMouseScroll(mouseScroll);
        }
    }

    public static void saveList(List<MouseScroll> mouseScrollList) {
        try {
            mouseScrollDAO.setSession(SessionTransaction.openSession());
            mouseScrollDAO.setTransaction(SessionTransaction.openTransaction(mouseScrollDAO.getSession()));
            mouseScrollDAO.saveList(mouseScrollList);
            SessionTransaction.closeTransaction(mouseScrollDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
            SendBuffer.addMouseScrollList(mouseScrollList);
        }
    }

}
