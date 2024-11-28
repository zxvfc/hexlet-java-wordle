package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application {
    String textStyle = "-fx-font-size: 25px;";
    int attemptCount = 0;

    public void start(Stage primaryStage) {
        WordleGame game = new WordleGame();
        int maxAttempts = 5;

        VBox root = new VBox(10);
        root.setStyle(textStyle);

        Label greetings = new Label(game.getGreetings());
        Label rules = new Label(game.getRules());

        TextField input = new TextField();
        Label result = new Label();
        GridPane attemptsInfo = new GridPane();

        Button submitButton = new Button("Проверить");
        submitButton.setOnAction(event -> {
            String userInput = input.getText();
            boolean isCorrect = game.isCorrect(userInput);
            if (isCorrect) {
                result.setText(game.getCongratulations());
                input.setDisable(true);
                submitButton.setDisable(true);
            } else {
                attemptCount++;
                Label attemptLabel = new Label();
                attemptLabel.setText("Попытка " + attemptCount + ": " + game.getFeedback(userInput));
                attemptsInfo.add(attemptLabel, 0, attemptCount);
                input.clear();
            }

            if (attemptCount >= maxAttempts) {
                result.setText(game.getFailMessage());
                input.setDisable(true);
                submitButton.setDisable(true);
            }
        });

        root.getChildren().addAll(
                greetings,
                rules,
                input,
                attemptsInfo,
                submitButton,
                result
        );
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
