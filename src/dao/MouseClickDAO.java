/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseClick;
import java.util.List;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją mouse_click w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class MouseClickDAO extends DAO implements MouseClickDAOInterface {

    /**
     * Zapisanie 1 obiektu MouseClick do bazy danych.
     *
     * @param mouseClick Obiekt do zapisania.
     */
    @Override
    public void save(MouseClick mouseClick) {
        getSession().save(mouseClick);
    }

    /**
     * Zapisanie listy obiektów MouseClick do bazy danych.
     *
     * @param mouseClickList Lista obiektów do zapisania.
     */
    @Override
    public void saveList(List<MouseClick> mouseClickList) {
        mouseClickList.forEach((mouseClick) -> {
            getSession().save(mouseClick);
        });
    }

}
