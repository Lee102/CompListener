/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KeyboardClick;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickDAO extends DAO implements KeyboardClickDAOInterface {

    @Override
    public void save(KeyboardClick keyboardClick) {
        getSession().save(keyboardClick);
    }

    @Override
    public void saveList(List<KeyboardClick> keyboardClickList) {
        keyboardClickList.forEach((keyboardClick) -> {
            getSession().save(keyboardClick);
        });
    }

}
