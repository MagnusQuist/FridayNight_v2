package com.example.fridaynight_v2.controllers;

import com.example.fridaynight_v2.Main;
import com.example.fridaynight_v2.controllers.sceneControllers.WardrobeController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainMenuController {
    private final int HEIGHT = 500;
    private final int WIDTH = 800;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void StartGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/wardrobe2.fxml"));
        root = loader.load();
        WardrobeController controller = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);

        scene.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case W -> controller.up();
                case A -> controller.left();
                case S -> controller.down();
                case D -> controller.right();
                default -> {
                }
            }
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(300), e ->{
            FXMLLoader QuizLoader = new FXMLLoader(Main.class.getResource("view/quiz.fxml"));
            try {
                root = QuizLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Scene QuizScene = new Scene(root, WIDTH, HEIGHT);
            stage.setScene(QuizScene);
        }));
        timeline.play();
    }

    public void ShowIntro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Main.class.getResource("view/introduction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
    }

    public void QuitGame() { System.exit(0);}
}
