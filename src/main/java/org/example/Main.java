package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxAttempts = 5;
        WordleGame game = new WordleGame();

        System.out.println(game.getGreetings());
        System.out.println(game.getRules());

        Scanner scanner = new Scanner(System.in);
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Попытка " + attempt + ": ");
            String userInput = scanner.nextLine().toLowerCase();

            if (game.isCorrect(userInput)) {
                System.out.println(game.getCongratulations());
                return;
            } else {
                String feedback = game.getFeedback(userInput);
                System.out.println("Подсказка: " + feedback);
            }
        }
        System.out.println(game.getFailMessage());
    }
}

/*
Загадать секретное слово
Повторять пока есть попытки
    Запросить у игрока вариант
    Сравнить ввод с секретным словом
    Если совпадает, то победа
    Иначе проверить буквы, которые используются и сгенерировать ответ по правилам:
    _ - отсутствует в секретном слове
    ? - буква не на своей позиции
    Вывести букву, если она на правильной позиции
*/


// комар

// точка
// _о_??

// кочка
// ко_??

// кочан
// ко_а_

// комар
//


// _ - отсутствует в секретном слове
// ? - буква не на своей позиции
