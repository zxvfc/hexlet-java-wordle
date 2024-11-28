package org.example;

import java.util.Random;

public class WordleGame {
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
    String secretWord;

    WordleGame() {
        int secretWordIndex = new Random().nextInt(dictionary.length);
        secretWord = dictionary[secretWordIndex].toLowerCase();
    }

    String getGreetings() {
        return "Добро пожаловать в Wordle!";
    }

    String getRules() {
        return "У вас будет 5 попыток, что бы отгадать секретное слово из 5-и букв";
    }


    boolean isCorrect(String guess) {
        return secretWord.equals(guess);
    }

    String getCongratulations() {
        return "Поздравляем! Вы отгадали секретное слово!";
    }

    String getFeedback(String guess) {
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

    String getFailMessage() {
        return "Вы проиграли. Секретное слово: " + secretWord;
    }
}
