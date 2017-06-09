/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Window;
import java.util.List;

/**
 *
 * @author Łukasz Wojtas
 */
public class WindowDAO extends DAO implements WindowDAOInterface {

    @Override
    public void save(Window window) {
        getSession().save(window);
    }

    @Override
    public void saveList(List<Window> windowList) {
        windowList.forEach((window) -> {
            getSession().save(window);
        });
    }

}
