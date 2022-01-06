package com.company;

import javax.swing.*;

// Главный класс игры
public class Game {

    // Главный метод, который запускает игру
    public static void main(String[] args) {
        String rez;
        int slogn = 0;

        // Сложность игры
        rez = JOptionPane.showInputDialog(null,
                "Введите сложность игры от 1 до 7",
                "Сложность игры", JOptionPane.INFORMATION_MESSAGE);

        // Проверка на ввод корректной сложности игры
        while(rez == null || rez.equals("") || slogn < 1 || slogn > 7) {
            // Переводим строку с число
            try {
                slogn = Integer.parseInt(rez);
                if (slogn < 1 || slogn > 7) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                rez = JOptionPane.showInputDialog(null,
                        "Вы ввели некорректную сложность игры",
                        "Введите заново", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Если все нормально введено, то просто окно игры создаем (передаем в него сложность игры)
        Okno window = new Okno(slogn);
    }

}
