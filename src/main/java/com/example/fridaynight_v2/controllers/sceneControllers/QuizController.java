package com.example.fridaynight_v2.controllers.sceneControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class QuizController {
    @FXML
    private VBox wrapper;
    @FXML
    private Button link;
    @FXML
    private Label copy_text;

    public void copyLink() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString("https://forms.gle/5teMAmsLRJVhCxNE6");
        clipboard.setContent(content);
        copy_text.setText("Linket er nu kopieret");
    }


}

