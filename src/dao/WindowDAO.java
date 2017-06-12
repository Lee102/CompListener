/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Window;
import java.util.List;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją window w bazie danych.
 *
 * @author Łukasz Wojtas
 */
public class WindowDAO extends DAO implements WindowDAOInterface {

    /**
     * Zapisanie 1 obiektu Window do bazy danych.
     *
     * @param window Obiekt do zapisania.
     */
    @Override
    public void save(Window window) {
        getSession().save(window);
    }

    /**
     * Zapisanie listy obiektów Window do bazy danych.
     *
     * @param windowList Lista obiektów do zapisania.
     */
    @Override
    public void saveList(List<Window> windowList) {
        windowList.forEach((window) -> {
            getSession().save(window);
        });
    }

}
