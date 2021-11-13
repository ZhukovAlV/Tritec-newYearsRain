package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Pole extends JPanel {
    private Image shapka;
    private Image fon;
    public int x = 400;

    public Pole() {

        try {
            fon = ImageIO.read(new File("resource/fon.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }

        try {
            shapka = ImageIO.read(new File("resource/shapka.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }

        Timer timerDraw = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fon,0,0,null);
        g.drawImage(shapka,x,465,null);
    }
}
