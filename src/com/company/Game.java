package com.company;

import javax.swing.*;

// Главный класс игры
public class Game {

    // Главный метод, который запускает игру
    public static void main(String[] args) {
        String rez;
        // Сложность игры
        rez = JOptionPane.showInputDialog(null,
                "Введите сложность игры от 1 до 7",
                "Сложность игры", JOptionPane.INFORMATION_MESSAGE);
        int slogn = Integer.parseInt(rez);

        // Проверка на ввод корректной сложности игры
        if(slogn >= 1 && slogn <= 7) {
            Okno window = new Okno(slogn);
        } else {
            rez = JOptionPane.showInputDialog(null,
                    "Вы ввели некорректную сложность игры",
                    "Введите заново", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
