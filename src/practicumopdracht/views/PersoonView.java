package practicumopdracht.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersoonView extends View {
    @Override
    public Scene getRoot() {
        VBox vBox = new VBox(new Label("PersoonView"));
        return new Scene(vBox);
    }
}
