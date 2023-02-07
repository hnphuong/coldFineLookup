package hnp.selenium.chromedriver.service;

import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class CropImageService {
    /**
     * Crops an image to the specified region
     *
     * @param bufferedImage the image that will be crop
     * @param x             the upper left x coordinate that this region will start
     * @param y             the upper left y coordinate that this region will start
     * @param width         the width of the region that will be crop
     * @param height        the height of the region that will be crop
     * @return the image that was cropped.
     */
    public BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height) {
        return bufferedImage.getSubimage(x, y, width, height);
    }

}
