/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jna.platform.win32.WinDef.RECT;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Łukasz Wojtas
 */
public class ScreenCapture {

    private static byte[] printScreen;

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

    public static byte[] getPrintScreen() {
        return printScreen;
    }

    public static void setPrintScreen(byte[] printScreen) {
        ScreenCapture.printScreen = printScreen;
    }

}
