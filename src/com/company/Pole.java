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
    public int x = 400, y = 500;
    // Переменная сложности игры
    private int slogn;
    // Массив с картинками подарков
    private Podar[] massPodar;
    //Размер массива
    int masSize = 7;
    // Картинка окончания игры
    private Image endGame;
    // Таймеры
    public Timer timerUpdate, timerDraw;
    // Количество собранных подарков
    int kolPodarCount;

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
        massPodar = new Podar[masSize];
        for(int i = 0; i < masSize; i++) {
            try {
                Image img = ImageIO.read(new File("resource/gift" + (i+1) + ".png"));
                massPodar[i] = new Podar(img);
            } catch (IOException e) {
                System.out.println("Не удалось загрузить файл");
            }
        }

        // Загружаем файл конца игры
        try {
            endGame = ImageIO.read(new File("resource/end_game.png"));
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }

        // Подаркогенератор
        timerUpdate = new Timer(500, new ActionListener() {
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
        g.drawImage(shapka,x,y,null);

        // Рисуем подарки
        for (int i = 0; i < masSize; i++) {
            // Если подарок true
            if (massPodar[i].act == true) {
                // Рисуем его
                massPodar[i].draw(g);

                // Если герой до него дотронулся, то выключаем подарок
                if (massPodar[i].y + 70 > y && (Math.abs(massPodar[i].x - x) < 80)) {
                    System.out.println("Герой дотронулся до подарка " + massPodar[i]);
                    massPodar[i].act = false;

                    // Увеличиваем счетчик собранных подарков
                    kolPodarCount++;
                // А если подарок пропущен, то конец игры
                } else if((massPodar[i].y + massPodar[i].getImg().getHeight(null) >= 730)) {
                    // Рисуем окончание игры
                    g.drawImage(endGame, 0, 0, null);
                    timerDraw.stop();
                    timerUpdate.stop();
                    break;
                }

                // Двигаем подарок вниз
                massPodar[i].vniz();
            }
        }
    }

    // Метод для проверки и добавления подарков на игровое поле
    private void updateStart() {
        int kol = 0;
        for (int i = 0; i < masSize; i++) {
            // Если подарок не на игровом поле
            if (massPodar[i].act == false) {
                if (kol < slogn) {
                    massPodar[i].start();
                    break;
                }
            } else kol++;
        }
    }
}
