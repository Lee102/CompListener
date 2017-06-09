/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WorkstationAdditionalDataDAO;
import entity.WorkstationAdditionalData;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataService {

    private static WorkstationAdditionalDataDAO workstationAdditionalDataDAO = new WorkstationAdditionalDataDAO();

    public static void save(WorkstationAdditionalData workstationAdditionalData) {
        try {
            workstationAdditionalDataDAO.setSession(SessionTransaction.openSession());
            workstationAdditionalDataDAO.setTransaction(SessionTransaction.openTransaction(workstationAdditionalDataDAO.getSession()));
            workstationAdditionalDataDAO.save(workstationAdditionalData);
            SessionTransaction.closeTransaction(workstationAdditionalDataDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
