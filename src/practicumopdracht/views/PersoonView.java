package practicumopdracht.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersoonView implements View {
    @Override
    public void getRoot(Stage stage) {
        VBox vBox = new VBox(new Label("PersoonView"));
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
    }
}
