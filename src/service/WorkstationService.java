/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WorkstationDAO;
import entity.Workstation;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationService {

    private static WorkstationDAO workstationDAO = new WorkstationDAO();

    public static void save(Workstation workstation) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            workstationDAO.setTransaction(SessionTransaction.openTransaction(workstationDAO.getSession()));
            workstationDAO.save(workstation);
            SessionTransaction.closeTransaction(workstationDAO.getTransaction());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static Workstation findByComputerName(String computerName) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            Workstation workstation = workstationDAO.findByComputerName(computerName);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstation;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static Workstation findByUserDomain(String userDomain) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            Workstation workstation = workstationDAO.findByUserDomain(userDomain);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstation;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static Workstation findByUserName(String userName) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            Workstation workstation = workstationDAO.findByUserName(userName);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstation;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static Workstation findByMACAddress(byte[] macAddress) {
        try {
            workstationDAO.setSession(SessionTransaction.openSession());
            Workstation workstation = workstationDAO.findByMACAddress(macAddress);
            SessionTransaction.closeSession(workstationDAO.getSession());
            return workstation;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
