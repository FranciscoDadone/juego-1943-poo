package com.cecchettodadone.juego1943;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Util {
    public static double FRAME_RATE = 60.0;

    public static BufferedImage getImage (String path) {
        try {
            return ImageIO.read(Util.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getFile (String path) {
        try {
            return new File(Util.class.getClassLoader().getResourceAsStream(path).toString());
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
