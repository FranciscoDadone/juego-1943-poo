package com.cecchettodadone.juego1943;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
}
