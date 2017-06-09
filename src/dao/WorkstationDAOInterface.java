/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Workstation;

/**
 *
 * @author Łukasz Wojtas
 */
public interface WorkstationDAOInterface {

    public void save(Workstation workstation);

    public Workstation findByComputerName(String computerName);

    public Workstation findByUserDomain(String userDomain);

    public Workstation findByUserName(String userName);

    public Workstation findByMACAddress(byte[] macAddress);

}
