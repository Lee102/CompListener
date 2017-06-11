/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Workstation;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationDAO extends DAO implements WorkstationDAOInterface {

    @Override
    public void save(Workstation workstation) {
        getSession().save(workstation);
    }

    @Override
    public List<Workstation> findByComputerName(String computerName) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName").setParameter("computerName", computerName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public List<Workstation> findByUserDomain(String userDomain) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_domain=:userDomain").setParameter("userDomain", userDomain);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public List<Workstation> findByUserName(String userName) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_name=:userName").setParameter("userName", userName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public List<Workstation> findByMACAddress(String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE mac_address=:macAddress").setParameter("macAddress", macAddress);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    @Override
    public Workstation findByAll(String computerName, String userDomain, String userName, String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName AND user_domain=:userDomain AND user_name=:userName AND mac_address=:macAddress").setParameter("computerName", computerName).setParameter("userDomain", userDomain).setParameter("userName", userName).setParameter("macAddress", macAddress);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

}
