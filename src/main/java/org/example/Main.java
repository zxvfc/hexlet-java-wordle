package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] dictionary = new String[]{
                "точка",
                "книга",
                "комар",
                "слово",
                "почка",
                "дочка",
                "ручка",
                "мячик",
                "пачка",
                "радий",
                "весна",
                "осень",
                "нолик"
        };
        int secretWordIndex = new Random().nextInt(dictionary.length);
        String secretWord = dictionary[secretWordIndex].toLowerCase();
        int maxAttempts = 5;

        System.out.println("Добро пожаловать в Wordle!");
        System.out.println("У вас будет " + maxAttempts + " попыток, что бы отгадать секретное слово из 5-и букв");

        Scanner scanner = new Scanner(System.in);
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Попытка " + attempt + ": ");
            String userInput = scanner.nextLine().toLowerCase();

            if (secretWord.equals(userInput)) {
                System.out.println("Поздравляем! Вы отгадали секретное слово!");
                return;
            } else {
                String feedback = getFeedback(secretWord, userInput);
                System.out.println("Подсказка: " + feedback);
            }
        }
        System.out.println("Вы проиграли. Секретное слово: " + secretWord);
    }

    static String getFeedback(String secretWord, String guess) {
        if (secretWord.length() != guess.length()) {
            return "Пожалуйста введите слово из 5-и букв";
        }

        String feedback = "";
        for (int i = 0; i < secretWord.length(); i++) {
            char currentSymbol = guess.charAt(i);
            if (secretWord.charAt(i) == currentSymbol) {
                feedback += currentSymbol;
            } else if (secretWord.contains(String.valueOf(currentSymbol))) {
                feedback += "?";
            } else {
                feedback += "_";
            }
        }
        return feedback;
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
