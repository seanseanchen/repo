package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PixelPedia {

    /** The list of games */
    private ArrayList<Game> games;

    /** The ListView containing the names of games */
    private ListView<String> listView;

    /**
     * Constructor for the PixelPedia class.
     * Initializes an ArrayList of Game objects, and a ListView for displaying the games.
     */
    public PixelPedia() {
        games = new ArrayList<Game>();
        listView = new ListView<String>();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage, and shows the main scene on the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("PixelPedia");
        showMainScene(primaryStage);    
    }

    /**
     * Displayss the main scene of the application.
     * It sets up the layout, scene, and stage, then shows the stage.
     *
     * @param primaryStage The primary stage on which the scene is set and shown.
     */
    public void showMainScene(Stage primaryStage) {
        TextField inputField = new TextField();
        Button addButton = new Button("Add Game");
        addButton.setOnAction(event -> addGame(inputField));

        VBox layout = new VBox(10, inputField, addButton, listView);
        Scene mainScene = new Scene(layout, 300, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Adds a new game to the list of games.
     * It first retrieves the text from the input field, checks if it's not empty,
     * then creates a new Game object with the input text and adds it to the games list.
     * After adding the new game, it sorts the games list, refreshes the list view,
     * and finally clears the input field.
     *
     * @param inputField TextField object that contains the name of the new game to be added.
     */
    public void addGame(TextField inputField) {
        String newGame = inputField.getText();

        if (!newGame.isEmpty()) {
            games.add(new Game(newGame));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the games in the 'games' list based on their titles.
     */
    public void sortGames() {
        
        
    }

    /**
     * Refreshes the list of games displayed in the listView.
     * It first clears the listView, then iterates over the 'games' list,
     * adding each game's name to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (Game game : games) {
            listView.getItems().add(game.getTitle());
        }
    }

}
