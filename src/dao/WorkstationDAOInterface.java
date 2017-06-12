/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Workstation;
import java.util.List;

/**
 * Interfejs klasy WorkstationDAO.
 *
 * @author Łukasz Wojtas
 */
public interface WorkstationDAOInterface {

    public void save(Workstation workstation);

    public List<Workstation> findByComputerName(String computerName);

    public List<Workstation> findByUserDomain(String userDomain);

    public List<Workstation> findByUserName(String userName);

    public List<Workstation> findByMACAddress(String macAddress);

    public Workstation findByAll(String computerName, String userDomain, String userName, String macAddress);

}
