package com.company;

import java.awt.*;

public class Podar {

    // Изображение подарка
    private Image img;
    public int x,y;
    // Видимость подарка
    public boolean act;

    public Podar(Image img) {
        this.img = img;

        // Изначально подарок невидим, т.е. false
        act = false;
    }

    public void start() {
        y = 0;
        x = (int)(Math.random()*1024);
        act = true;
    }

    public void vniz() {
        y+=6;
    }

    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
    }

    public Image getImg() {
        return img;
    }
}
