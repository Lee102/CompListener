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
 * Klasa DAO służąca do obsługi komunikacji z encją workstation w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class WorkstationDAO extends DAO implements WorkstationDAOInterface {

    /**
     * Zapisanie 1 obiektu Workstation do bazy danych.
     *
     * @param workstation Obiekt do zapisania.
     */
    @Override
    public void save(Workstation workstation) {
        getSession().save(workstation);
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru computer_name.
     *
     * @param computerName Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByComputerName(String computerName) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName").setParameter("computerName", computerName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru user_domain.
     *
     * @param userDomain Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByUserDomain(String userDomain) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_domain=:userDomain").setParameter("userDomain", userDomain);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru user_name.
     *
     * @param userName Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByUserName(String userName) {
        Query query = getSession().createQuery("FROM Workstation WHERE user_name=:userName").setParameter("userName", userName);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektów w bazie danych za pomocą parametru mac_address.
     *
     * @param macAddress Wartość parametru do wyszukiwania.
     * @return Lista obiektów Workstation lub null.
     */
    @Override
    public List<Workstation> findByMACAddress(String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE mac_address=:macAddress").setParameter("macAddress", macAddress);
        List<Workstation> workstationList = query.list();
        return workstationList;
    }

    /**
     * Wyszukanie obiektu w bazie danych za pomocą wszystkich możliwych
     * parametrów.
     *
     * @param computerName Wartość parametru computer_name do wyszukiwania.
     * @param userDomain Wartość parametru user_domain do wyszukiwania.
     * @param userName Wartość parametru user_name do wyszukiwania.
     * @param macAddress Wartość parametru mac_address do wyszukiwania.
     * @return Obiekt Workstation lub null.
     */
    @Override
    public Workstation findByAll(String computerName, String userDomain, String userName, String macAddress) {
        Query query = getSession().createQuery("FROM Workstation WHERE computer_name=:computerName AND user_domain=:userDomain AND user_name=:userName AND mac_address=:macAddress").setParameter("computerName", computerName).setParameter("userDomain", userDomain).setParameter("userName", userName).setParameter("macAddress", macAddress);
        Workstation workstation = (Workstation) query.uniqueResult();
        return workstation;
    }

}
