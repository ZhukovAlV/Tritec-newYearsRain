package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno extends JFrame {

    private Pole gamePole;

    public Okno() {

        setFocusable(true);
        setBounds(0,0,1024,768);
        setTitle("Новогодний дождь");

        gamePole = new Pole();
        Container container = getContentPane();
        container.add(gamePole);

        setVisible(true);

        addKeyListener(new MyKey());
    }

    class MyKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyValue = e.getKeyCode();
            if (keyValue == 27) {
                System.exit(0);
            } else if (keyValue == 37) {
                if(gamePole.x - 30 > -48) gamePole.x -=30;
                else gamePole.x = 752;
            } else if (keyValue == 39) {
                if(gamePole.x + 30 < 994) gamePole.x +=30;
                else gamePole.x = -48;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
