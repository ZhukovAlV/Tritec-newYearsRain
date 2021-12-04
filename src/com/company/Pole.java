package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Pole extends JPanel {
    // Наш супергерой, который собирает подарки
    private Image shapka;
    // Фон для игры
    private Image fon;
    // Переменная для размещения супергероя
    public int x = 400;
    // Переменная сложности игры
    private int slogn;
    // Массив с картинками подарков
    private Podar[] massPodar;
    // Картинка окончания игры
    private Image endGame;
    // Таймеры
    public Timer timerUpdate, timerDraw;

    public Pole(int slogn) {

        // Выставляем сложность игры
        this.slogn = slogn;

        // Загружаем фон
        try {
            fon = ImageIO.read(new File("resource/fon.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }

        // Загружаем героя
        try {
            shapka = ImageIO.read(new File("resource/person.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }

        // Загружаем подарки
        massPodar = new Podar[7];
        for(int i = 0; i < 7; i++) {
            try {
                Image img = ImageIO.read(new File("resource/gift" + (i+1) + ".png"));
                massPodar[i] = new Podar(img);
            } catch (IOException e) {
                System.out.println("Не удалось загрузить файл");
            }
        }

        // Загружаем файл конца игры
        try {
            endGame = ImageIO.read(new File("resource/game_end.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }

        // Подаркогенератор
        timerUpdate = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStart();
            }
        });
        timerUpdate.start();

        // Перерисовывает наше поле каждые 50 мс (20 раз в секунду)
        timerDraw = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Рисуем фон
        g.drawImage(fon,0,0,null);

        // Рисуем супергероя
        g.drawImage(shapka,x,465,null);

        // Рисуем подарки
        for (int i = 0; i < 7; i++) {
            massPodar[i].draw(g);

            // Если подарок отображается
            if (massPodar[i].act = true) {

                // Если подарок пропущен
                if (Math.abs(massPodar[i].x - x) > 75) {
                    // Рисуем окнчание игры
                    g.drawImage(endGame, 300, 300, null);
                    timerDraw.stop();
                    timerUpdate.stop();
                    break;
                } else {
                    massPodar[i].act = false;
                }
            }
        }
    }

    // Метод для проверки и добавления подарков на игровое поле
    private void updateStart() {
        int kol = 0;
        for (int i = 0; i < 7; i++) {
            // Если подарок не на игровом поле
            if (massPodar[i].act == false) {
                if (kol < slogn) {
                    massPodar[i].start();
                    break;
                } else {
                    kol++;
                }
            }
        }
    }
}
