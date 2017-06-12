/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Klasa używana do obsługi ikony w System Tray wraz z jej dodatkowymi
 * funkcjami: "About" - podstawowe informacje o programie oraz "Exit" -
 * wyłącznie programu.
 *
 * @author Łukasz Wojtas
 */
public class TrayIcon {

    /**
     * Utworzenie ikony w System Tray, utrzymanie jej oraz obsługa dodatkowych
     * akcji.
     */
    public static void trayIcon() {
        try {
            if (SystemTray.isSupported()) {
                final PopupMenu popup = new PopupMenu();
                File file = new File("trayIcon.png");
                Image image = ImageIO.read(file);
                final java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image, "tray icon");
                final SystemTray tray = SystemTray.getSystemTray();
                MenuItem about = new MenuItem("About");
                ActionListener aboutListener = (ActionEvent ae) -> {
                    JOptionPane.showMessageDialog(null, "CompListenerViewer\nAuthor: Łukasz Wojtas");
                };
                about.addActionListener(aboutListener);
                popup.add(about);
                MenuItem close = new MenuItem("Exit");
                ActionListener closeListener = (ActionEvent ae) -> {
                    tray.remove(trayIcon);
                    CompListener.setEnd(1);
                };
                close.addActionListener(closeListener);
                popup.add(close);
                trayIcon.setPopupMenu(popup);

                tray.add(trayIcon);
            } else {
                System.err.println("SystemTray is not supported");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
