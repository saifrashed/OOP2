package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.BedrijfController;
import practicumopdracht.controllers.Controller;
import practicumopdracht.controllers.PersoonController;

public class MainApplication extends Application {

    private static Stage primaryStage;

    private final String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);
            return;
        }

        MainApplication.primaryStage = stage;

        BedrijfController bedrijf = new BedrijfController();

        MainApplication.switchController(bedrijf);

        primaryStage.setTitle(this.TITLE);
        primaryStage.setWidth(this.WIDTH);
        primaryStage.setHeight(this.HEIGHT);
        primaryStage.show();
    }

    /**
     * Handles Switching of controllers
     */
    public static void switchController(Controller controller) {
        MainApplication.primaryStage.setScene(new Scene(controller.getView()));
    }
}
