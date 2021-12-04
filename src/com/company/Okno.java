package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno extends JFrame {

    // Игровое поле
    private Pole gamePole;
    // Сложность игры
    private int slogn;

    // Конструктор окна (задаем необходимые параметры)
    public Okno(int slogn) {

        // Задаем сложность игры
        this.slogn = slogn;

        // Задаем параметры для окна
        setFocusable(true);
        setBounds(0,0,1024,768);
        setTitle("Новогодний дождь");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание объекта игрового поля
        gamePole = new Pole(slogn);
        Container container = getContentPane();
        container.add(gamePole);

        setVisible(true);

        // Устанавливаем слушаетял на клавиатуру
        addKeyListener(new MyKey());
    }


    class MyKey implements KeyListener {

        // Метод, который отрабатываем при нажатии
        @Override
        public void keyPressed(KeyEvent e) {
            // Получение кода нажатой клавиши
            int keyValue = e.getKeyCode();

            // Если нажат ESC выходим из игры
            if (keyValue == 27) {
                System.exit(0);
                // Если нажата клавища ВЛЕВО
            } else if (keyValue == 37) {
                if(gamePole.x - 30 > -48) gamePole.x -=30;
                else gamePole.x = 752;
                // Если нажата клавища ВПРАВО
            } else if (keyValue == 39) {
                if(gamePole.x + 30 < 994) gamePole.x +=30;
                else gamePole.x = -48;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}
