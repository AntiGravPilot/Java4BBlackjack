import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * Main method; Launches the JavaFX program.
 * Start method; Sets the primary stage and scene, window size, and the primary pane (that being the Blackjack pane). Displays the scene.
 * @author Brandon
 */
public class Main extends Application {

    Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Blackjack");

        BorderPane layout;

        BlackjackPane blackjack = new BlackjackPane();
        layout = blackjack.getBlackjack();

        Scene scene = new Scene(layout, 1200, 820);
        scene.getStylesheets().add("Deco.css");
        window.setScene(scene);
        window.show();
    }
}
