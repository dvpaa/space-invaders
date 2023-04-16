package org.newdawn.spaceinvaders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ImageUtil {
    private ImageUtil() throws IllegalAccessException {
        throw new IllegalAccessException("This is Utility Class");
    }

    public static Image getImage(Class<?> clazz, String filename) {
        try {
            return ImageIO.read(Objects.requireNonNull(clazz.getResourceAsStream(
                    "/" + filename)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
