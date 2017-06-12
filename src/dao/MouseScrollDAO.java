/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseScroll;
import java.util.List;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją mouse_scroll w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollDAO extends DAO implements MouseScrollDAOInterface {

    /**
     * Zapisanie 1 obiektu MouseScroll do bazy danych.
     *
     * @param mouseScroll Obiekt do zapisania.
     */
    @Override
    public void save(MouseScroll mouseScroll) {
        getSession().save(mouseScroll);
    }

    /**
     * Zapisanie listy obiektów MouseScroll do bazy danych.
     *
     * @param mouseScrollList Lista obiektów do zapisania.
     */
    @Override
    public void saveList(List<MouseScroll> mouseScrollList) {
        mouseScrollList.forEach((mouseScroll) -> {
            getSession().save(mouseScroll);
        });
    }

}
