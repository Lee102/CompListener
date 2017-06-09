/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseClick;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public class MouseClickDAO extends DAO implements MouseClickDAOInterface {

    @Override
    public void save(MouseClick mouseClick) {
        getSession().save(mouseClick);
    }

    @Override
    public void saveList(List<MouseClick> mouseClickList) {
        mouseClickList.forEach((mouseClick) -> {
            getSession().save(mouseClick);
        });
    }

}
