/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.MouseScroll;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollDAO extends DAO implements MouseScrollDAOInterface {

    @Override
    public void save(MouseScroll mouseScroll) {
        getSession().save(mouseScroll);
    }

    @Override
    public void saveList(List<MouseScroll> mouseScrollList) {
        mouseScrollList.forEach((mouseScroll) -> {
            getSession().save(mouseScroll);
        });
    }

}
