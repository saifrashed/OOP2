package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.*;
import practicumopdracht.data.*;

/**
 * MainApplication klasse
 * <p>
 * Hier wordt de applicatie geinitialiseerd in de start methode.
 * Ook worden gegevens ingeladen en beschikbaar gesteld voor de
 * controllers.
 */
public class MainApplication extends Application {

    private static Stage primaryStage;

    //private static BedrijfDao bedrijf = new TextBedrijfDao();
    //private static BedrijfDao bedrijf = new FakeBedrijfDao();
    private static final BedrijfDao bedrijf = new BinaryBedrijfDAO();

    //private static PersoonDao persoon = new TextPersoonDao();
    //private static PersoonDao persoon = new FakePersoonDao();
    private static final PersoonDao persoon = new ObjectPersoonDAO();

    private final String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    /**
     * Applicatie start methode (hier initialiseerd de JavaFX applicatie)
     *
     * @param stage Stage JavaFX object
     */
    @Override
    public void start(Stage stage) {
        if (!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);
            return;
        }

        primaryStage = stage; // de stage bereikbaar maken voor andere methodes

        bedrijf.load(); // Bedrijf gegevens inladen
        persoon.load(); // Persoon gegevens inladen

        switchController(new BedrijfController()); // Bedrijf als eerst weergeven

        primaryStage.setTitle(this.TITLE);
        primaryStage.setWidth(this.WIDTH);
        primaryStage.setHeight(this.HEIGHT);
        primaryStage.show();
    }

    /**
     * Handles Switching of controllers
     */
    public static void switchController(Controller controller) {
        primaryStage.setScene(new Scene(controller.getView()));
    }

    /**
     * BedrijfDAO ophalen
     *
     * @return BedrijfDAO object
     */
    public static BedrijfDao getBedrijven() {
        return bedrijf;
    }

    /**
     * PersoonDAO ophalen
     *
     * @return PersoonDAO object
     */
    public static PersoonDao getPersoon() {
        return persoon;
    }

    /**
     * Applicatie stage ophalen
     *
     * @return Stage object
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
