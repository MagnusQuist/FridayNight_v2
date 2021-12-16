package com.example.fridaynight_v2.controllers.sceneControllers;

import com.example.fridaynight_v2.Main;
import com.example.fridaynight_v2.utils.Collectable;
import com.example.fridaynight_v2.utils.Fact;
import com.example.fridaynight_v2.utils.Interactable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class Bar1Controller implements Initializable {
    private ArrayList<Interactable> items = new ArrayList<>();
    private ImageView avatar;
    private VBox popup = new VBox();
    private final int HEIGHT = 500;
    private final int WIDTH = 800;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML private StackPane wrapper;
    @FXML private GridPane grid;
    @FXML private Label alko;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add player image to grid
        AddCollectables();
        AddPlayerImage();
        this.alko.setText("Promille: " + Main.player.getIntoxication());
    }

    public void gotoBar2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/bar2.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Bar2Controller controller = loader.getController();
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
    }

    public void gotoToilet(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/toilet.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        ToiletController controller = loader.getController();
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
    }

    public void gotoWardrobe(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/wardrobe2.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        WardrobeController controller = loader.getController();
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
    }

    public void gotoDanceFloor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/dancefloor.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        DanceFloorController controller = loader.getController();
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
    }

    public void up() {
        int r = 0;
        if (Main.player.getIntoxication() >= 0.5) {
            r = ThreadLocalRandom.current().nextInt(0, 2+1);
            System.out.println("You've had too much to drink, and took " + r + " extra step(s).");
        }
        GridPane.setRowIndex(this.avatar, GridPane.getRowIndex(this.avatar)-1-r);
        checkCollide(GridPane.getRowIndex(this.avatar), GridPane.getColumnIndex(this.avatar));
    }

    public void down() {
        int r = 0;
        if (Main.player.getIntoxication() >= 0.5) {
            r = ThreadLocalRandom.current().nextInt(0, 2+1);
            System.out.println("You've had too much to drink, and took " + r + " extra step(s).");
        }
        GridPane.setRowIndex(this.avatar, GridPane.getRowIndex(this.avatar)+1+r);
        checkCollide(GridPane.getRowIndex(this.avatar), GridPane.getColumnIndex(this.avatar));
    }

    public void left() {
        int r = 0;
        if (Main.player.getIntoxication() >= 0.5) {
            r = ThreadLocalRandom.current().nextInt(0, 2+1);
            System.out.println("You've had too much to drink, and took " + r + " extra step(s).");
        }
        GridPane.setColumnIndex(this.avatar, GridPane.getColumnIndex(this.avatar)-1-r);
        checkCollide(GridPane.getRowIndex(this.avatar), GridPane.getColumnIndex(this.avatar));
    }

    public void right() {
        int r = 0;
        if (Main.player.getIntoxication() >= 0.5) {
            r = ThreadLocalRandom.current().nextInt(0, 2+1);
            System.out.println("You've had too much to drink, and took " + r + " extra step(s).");
        }
        GridPane.setColumnIndex(this.avatar, GridPane.getColumnIndex(this.avatar)+1+r);
        checkCollide(GridPane.getRowIndex(this.avatar), GridPane.getColumnIndex(this.avatar));
    }

    private void checkCollide(int x, int y) {
        Node item = getNodeByRowColumnIndex(x, y);
        if (item != null && item.getId() != null) {
            Interactable itemFromList = this.items.get(Integer.parseInt(item.getId()));
            if (itemFromList instanceof Collectable) {
                // Check if beer or clock
                if (((Collectable) itemFromList).getType().equals("Tooborg")) {
                    Main.player.setIntoxication(12/(77*0.7)-(0.15*0.5));
                    this.alko.setText("Promille: " + Main.player.getIntoxication());
                } else if (((Collectable) itemFromList).getType().equals("Clock")) {
                    if (Main.player.getIntoxication() >= 0.1) {
                        Main.player.decreaseIntoxication(((Collectable) itemFromList).getAp());
                        this.alko.setText("Promille: " + Main.player.getIntoxication());
                    }
                }

            } else if (itemFromList instanceof Fact) {
                showPopup((Fact) itemFromList);
            }
            this.grid.getChildren().remove(item);
        }
    }

    private void showPopup(Fact fact) {
        // Remove previous content
        this.wrapper.getChildren().remove(popup);
        this.popup.getChildren().clear();
        this.popup.getStyleClass().add("popup");

        // Popup position
        this.popup.setAlignment(Pos.CENTER);

        Label heading = new Label("Fact Fundet!");
        heading.getStyleClass().add("heading");
        Button closeBtn = new Button("Luk");
        closeBtn.getStyleClass().add("btn");
        Label message = new Label(fact.getFact());
        BoxBlur blur = new BoxBlur();
        blur.setWidth(2);
        blur.setHeight(2);
        if (Main.player.getIntoxication() >= 0.5 && Main.player.getIntoxication() < 1.0) {
            blur.setIterations(1);
            message.setEffect(blur);
        } else if (Main.player.getIntoxication() >= 1.0) {
            blur.setIterations(100);
            message.setEffect(blur);
        }
        message.setWrapText(true);
        message.getStyleClass().add("fact_message");
        popup.getChildren().add(heading);
        popup.getChildren().add(message);
        popup.getChildren().add(closeBtn);
        popup.setVisible(true);

        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                popup.setVisible(false);
            }
        });
        this.wrapper.getChildren().add(popup);
    }

    private Node getNodeByRowColumnIndex(final int row, final int column) {
        Node result = null;
        ObservableList<Node> children = grid.getChildren();
        for (Node node: children) {
            if (GridPane.getColumnIndex(node) != null
                    && GridPane.getRowIndex(node) != null
                    && GridPane.getRowIndex(node) == row
                    && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    public void AddPlayerImage() {
        // Make image container
        this.avatar = new ImageView();
        // Set image size
        this.avatar.setFitHeight(100); this.avatar.setFitWidth(100);
        // Get image from resources
        final Image image = new Image(Main.class.getResourceAsStream("images/avatar.png"));
        // Add image to image container
        this.avatar.setImage(image);
        this.grid.add(this.avatar, Main.player.getX(), Main.player.getY(), 1, 1);
    }

    public void AddCollectables() {
        // Add Scene Fact
        items.add(new Fact("Vidste du at... Drikker man 5 eller flere genstande ved én lejlighed kaldes det “binge-drinking”. " +
                "Binge-drinking medfører stor risiko for ulykker, forgiftninger samt udvikling af alkoholafhængighed.",
                (int)(1+(Math.random() * (11 - 2))) , (int)(1+(Math.random() * (11 - 2)))));

        // Add Beers
        for (int i = 0; i < 6; i++) {
            Collectable item = new Collectable(4.3, "Tooborg",
                    (int)(1+(Math.random() * (11 - 2))) , (int)(1+(Math.random() * (11 - 2))), "images/tooborg.png");
            this.items.add(item);
        }

        for (int i = 0; i < (int)(1+(Math.random() * (3 - 1))); i++) {
            Collectable item = new Collectable(0.8, "Clock", (int)(1+(Math.random() * (11 - 2))) ,
                    (int)(1+(Math.random() * (11 - 2))), "images/clock.png");
            this.items.add(item);
        }

        for (int i = 0; i<items.size(); i++) {
            items.get(i).getIcon().setId(""+i);
            this.grid.add(items.get(i).getIcon(), items.get(i).getX(), items.get(i).getY(), 1, 1);
        }
    }
}
