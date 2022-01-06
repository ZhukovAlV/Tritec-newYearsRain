package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hero {
    // Наш супергерой, который собирает подарки
    private Image image;

    // Переменная для размещения супергероя
    private int x = 400, y = 500;

    public Hero() {
        // Загружаем героя
        try {
            image = ImageIO.read(new File("resource/person.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл героя");
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }
}
