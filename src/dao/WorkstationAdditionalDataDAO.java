/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.WorkstationAdditionalData;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataDAO extends DAO implements WorkstationAdditionalDataDAOInterface {

    @Override
    public void save(WorkstationAdditionalData workstationAdditionalData) {
        getSession().save(workstationAdditionalData);
    }

}
