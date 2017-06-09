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
public interface KeyboardClickDAOInterface {

    public void save(KeyboardClick keyboardClick);

    public void saveList(List<KeyboardClick> keyboardClickList);

}
