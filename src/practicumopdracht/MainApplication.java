package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.BedrijfController;
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
        MainApplication.switchController(false);

        primaryStage.setTitle(this.TITLE);
        primaryStage.setWidth(this.WIDTH);
        primaryStage.setHeight(this.HEIGHT);
        primaryStage.show();
    }

    /**
     * Handles Switching of controllers
     * @param isDetail Checks if controller is a detailpage
     */
    public static void switchController(boolean isDetail) {
        BedrijfController bedrijf = new BedrijfController();
        PersoonController persoon = new PersoonController();

        if (isDetail) {
            MainApplication.primaryStage.setScene(new Scene(persoon.getView()));
        } else {
            MainApplication.primaryStage.setScene(new Scene(bedrijf.getView()));
        }
    }
}
