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
 *
 * @author Łukasz Wojtas
 */
public class MouseClickService {

    private static MouseClickDAO mouseClickDAO = new MouseClickDAO();

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
