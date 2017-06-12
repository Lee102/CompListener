/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WorkstationAdditionalDataDAO;
import entity.WorkstationAdditionalData;

/**
 * Service klasy WorkstationAdditionalDataDAO.
 *
 * @see WorkstationAdditionalDataDAO {@link WorkstationAdditionalDataDAO}
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataService {

    /**
     * Prywatne, statyczne i zainicjowane pole klasy
     * WorkstationAdditionalDataService.
     */
    private static WorkstationAdditionalDataDAO workstationAdditionalDataDAO = new WorkstationAdditionalDataDAO();

    /**
     * Wywołanie metody save() klasy WorkstationAdditionalDataDAO oraz
     * zarządzanie sesją i transakcją.
     *
     * @param workstationAdditionalData Parametr do metody klasy
     * WorkstationAdditionalDataDAO.
     */
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
