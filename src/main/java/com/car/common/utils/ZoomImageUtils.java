package com.car.common.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * writer:dy
 */
public class ZoomImageUtils {
    //将图片转成图片输入流，需要参数：本地图片路径
    public void zoomImage(String picPath,String newPicPath,Integer times) {
        String path = newPicPath.substring(0,newPicPath.lastIndexOf("/")+1);
        File newFile = new File(path);
        if (!newFile.exists()){
            newFile.mkdirs();
        }
        BufferedImage bufferedImage = null;
        File file = new File(picPath);
        if (file.canRead()) {
            try {
                //读取图像文件
                bufferedImage = ImageIO.read(file);
                bufferedImage = zoomInImage(bufferedImage, times);
                //把生成的图片写到一个文件中
                ImageIO.write(bufferedImage, "JPG", new File(newPicPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedImage zoomInImage(BufferedImage bufferedImage, Integer times) {
        int width = bufferedImage.getWidth() / times;
        int height = bufferedImage.getHeight() / times;

        BufferedImage newImage = new BufferedImage(width, height, bufferedImage.getType());
        Graphics graphics = newImage.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, width, height, null);
        graphics.dispose();
        return newImage;
    }

    public static void main(String[] args) {
        new ZoomImageUtils().zoomImage("D:/pic/img/0000.jpg","D:/picture/1.jpg",4);
    }
}
