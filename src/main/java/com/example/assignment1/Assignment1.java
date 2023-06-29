package com.example.assignment1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Assignment1 extends Application {

    private static final String BACKGROUND_IMAGE_PATH = "Smash_hit.jpg";  // Replace with the correct path to your image file

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Smash hit");

        // Load the background image
        Image backgroundImage = new Image(BACKGROUND_IMAGE_PATH);
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        // Create the root pane and set the background
        BorderPane rootPane = new BorderPane();
        rootPane.setBackground(new Background(background));


        // Create and configure the center pane for the compelling message
        StackPane messagePane = new StackPane();

        Text headingText = new Text("Shatter the Limits, Unleash Your Skills " +
                "\n- Become the Ultimate Glass Demolisher in Smash Hit!");
        headingText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headingText.setFill(Color.WHITE);

        Text messageText = new Text(
                  "In Smash Hit, prepare for an exhilarating glass-shattering experience! Take aim, tap the" +
                "\nscreen, and unleash a barrage of metal balls to break through mesmerizing glass structures." +
                "\nWith the camera propelling you forward, every shot counts as you face a moving target in a" +
                "\nstunning 3D world." +

              "\n\nYour objective is clear: demolish obstacles and advance through the game. Some targets" +
                "\ngrant you additional balls upon impact, while others test your precision and timing. Be" +
                "\ncareful though, as hitting obstacles without destroying them will cost you precious balls." +
                "\nManage your limited ammunition wisely, as running out means game over." +

              "\n\nAre you ready to showcase your aiming skills, overcome challenges, and dominate the" +
                "\nleaderboard? Dive into the addictive gameplay of Smash Hit and unleash the power within" +
                "\nyou!\n");

        messageText.setFont(Font.font("Arial", 20));
        messageText.setFill(Color.WHITESMOKE);

        // Create and configure the play button
        Button playButton = new Button("Play");
        playButton.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Set the font weight and size of the button
        playButton.setStyle("-fx-pref-width: 120px; -fx-pref-height: 40px;"); // Set the size of the button

        VBox messageBox = new VBox(10); // Set the spacing between the heading and message
        messageBox.setAlignment(Pos.CENTER_LEFT);
        messageBox.setPadding(new Insets(150,0,0,35));
        messageBox.setSpacing(10);
        messageBox.getChildren().addAll(headingText, messageText, playButton );

        messagePane.getChildren().add(messageBox);


        // Create and configure the game name text
        Text gameNameText = new Text("Smash Hit");
        gameNameText.setFill(Color.WHITE);
        gameNameText.setFont(Font.font("SansSerif", 40));


        Region spacing1 = new Region();
        HBox.setHgrow(spacing1, Priority.ALWAYS);

        Region spacing2 = new Region();
        HBox.setHgrow(spacing2, Priority.ALWAYS);

        // Create and configure the top-right social media icons
        ImageView icon1 = new ImageView(new Image("social_icon1.png"));
        icon1.setFitHeight(30);
        icon1.setPreserveRatio(true);
        ImageView icon2 = new ImageView(new Image("social_icon2.png"));
        icon2.setFitHeight(30);
        icon2.setPreserveRatio(true);
        ImageView icon3 = new ImageView(new Image("social_icon3.png"));
        icon3.setFitHeight(30);
        icon3.setPreserveRatio(true);


        // Create and configure the menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color: transparent;-fx-color: #000000");

        Menu menu = new Menu("Menu");
        Menu settingMenu = new Menu("Setting");
        Menu helpMenu = new Menu("Help");

        // Add menus to the menu bar
        menuBar.getMenus().addAll(menu, settingMenu, helpMenu);

        // Add the game name, menu bar, and social media icons to a VBox
        HBox menuPane = new HBox();
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setPadding(new Insets(10));
        menuPane.getChildren().addAll(gameNameText,spacing1, menuBar, spacing2, icon1, icon2, icon3);

        // Add the panes to the root pane
        rootPane.setTop(menuPane);
        rootPane.setCenter(messagePane);


        // Create the scene
        Scene scene = new Scene(rootPane, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
