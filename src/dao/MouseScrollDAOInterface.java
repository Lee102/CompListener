/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseScroll;
import java.util.List;

/**
 * Interfejs klasy MouseScrollDAO.
 *
 * @author Łukasz Wojtas
 */
public interface MouseScrollDAOInterface {

    public void save(MouseScroll mouseScroll);

    public void saveList(List<MouseScroll> mouseScrollList);

}
