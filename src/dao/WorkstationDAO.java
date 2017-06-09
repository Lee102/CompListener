/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Workstation;
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
    public Workstation findByComputerName(String computerName) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName").setParameter("computerName", computerName);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

    @Override
    public Workstation findByUserDomain(String userDomain) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_domain=:userDomain").setParameter("userDomain", userDomain);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

    @Override
    public Workstation findByUserName(String userName) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_name=:userName").setParameter("userName", userName);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

    @Override
    public Workstation findByMACAddress(byte[] macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE mac_address=:macAddress").setParameter("macAddress", macAddress);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

}
