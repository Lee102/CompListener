/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jna.platform.win32.WinDef.RECT;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

/**
 * Klasa używana do wykonania zrzutu ekranu dla nowo otwartego okna.
 *
 * @author Łukasz Wojtas
 */
public class ScreenCapture {

    /**
     * Prywatna tablica bitowa zawierająca wykonany zrzut ekranu.
     */
    private static byte[] printScreen;

    /**
     * Wykonanie zrzutu ekranu dla okna określonego przez parametr.
     *
     * @param rect Współrzędne lewego górnego oraz prawego dolnego wierzchołka
     * okna.
     */
    public static void snapShot(RECT rect) {
        try {
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle();
            rectangle.setRect((double) rect.left, (double) rect.top, (double) rect.right - (double) rect.left, (double) rect.bottom - (double) rect.top);
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            printScreen = new byte[byteArrayOutputStream.toByteArray().length];
            printScreen = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * Getter pola printScreen.
     *
     * @return Wartość pola printScreen.
     */
    public static byte[] getPrintScreen() {
        return printScreen;
    }

    /**
     * Setter pola printScreen.
     *
     * @param printScreen Wartość do zapisania do pola printScreen.
     */
    public static void setPrintScreen(byte[] printScreen) {
        ScreenCapture.printScreen = printScreen;
    }

}
