package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Podar {

    // Изображение подарка
    private Image img;
    public int x,y;
    // Видимость подарка
    public Boolean act;
    // Таймер движения подарка
    private Timer timerUpdate;

    public Podar(Image img) {
        this.img = img;

        timerUpdate = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vniz();
            }
        });

        // Изначально подарок невидим
        act = false;

        // Запускаем движение подарков
      //  start();
    }

    public void start() {
        timerUpdate.start();
        y = 0;
        x = (int)(Math.random()*1024);
        act = true;
    }

    public void vniz() {
        if (act = true) {
            y+=6;
        }

        if (y + img.getHeight(null) >= 768) {
            timerUpdate.stop();
        }
    }

    public void draw(Graphics g) {
        if (act = true) {
            g.drawImage(img,x,y,null);
        }
    }
}
