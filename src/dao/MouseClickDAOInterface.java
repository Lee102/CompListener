/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseClick;
import java.util.List;

/**
 * Interfejs klasy MouseClickDAO.
 *
 * @author Łukasz Wojtas
 */
public interface MouseClickDAOInterface {

    public void save(MouseClick mouseClick);

    public void saveList(List<MouseClick> mouseClickList);

}
