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
public interface WindowDAOInterface {

    public void save(Window window);

    public void saveList(List<Window> windowList);

}
