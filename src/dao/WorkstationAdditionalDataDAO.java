/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.WorkstationAdditionalData;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją workstation_additional_data
 * w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataDAO extends DAO implements WorkstationAdditionalDataDAOInterface {

    /**
     * Zapisanie 1 obiektu WorkstationAdditionalData do bazy danych.
     *
     * @param workstationAdditionalData Obiekt do zapisania.
     */
    @Override
    public void save(WorkstationAdditionalData workstationAdditionalData) {
        getSession().save(workstationAdditionalData);
    }

}
