/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KeyboardClick;
import java.util.List;

/**
 * Klasa DAO służąca do obsługi komunikacji z encją keyboard_click w bazie
 * danych.
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickDAO extends DAO implements KeyboardClickDAOInterface {

    /**
     * Zapisanie 1 obiektu KeyboardClick do bazy danych.
     *
     * @param keyboardClick Obiekt do zapisania.
     */
    @Override
    public void save(KeyboardClick keyboardClick) {
        getSession().save(keyboardClick);
    }

    /**
     * Zapisanie listy obiektów KeyboardClick do bazy danych.
     *
     * @param keyboardClickList Lista obiektów do zapisania.
     */
    @Override
    public void saveList(List<KeyboardClick> keyboardClickList) {
        keyboardClickList.forEach((keyboardClick) -> {
            getSession().save(keyboardClick);
        });
    }

}
