package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import practicumopdracht.controllers.BedrijfController;
import practicumopdracht.controllers.Controller;
import practicumopdracht.controllers.MenuController;
import practicumopdracht.data.*;
import practicumopdracht.models.Bedrijf;

import java.util.List;

public class MainApplication extends Application {

    private static BorderPane mainPane;

//    private static BedrijfDao bedrijf = new TextBedrijfDao();
//    private static BedrijfDao bedrijf = new FakeBedrijfDao();
     private static BedrijfDao bedrijf = new BinaryBedrijfDAO();

//    private static PersoonDao persoon = new TextPersoonDao();
//    private static PersoonDao persoon = new FakePersoonDao();
    private static PersoonDao persoon = new ObjectPersoonDAO();




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

        bedrijf.load();
        persoon.load();

        List<Bedrijf> list = bedrijf.getAll();

        mainPane = new BorderPane();

        mainPane.setTop(new MenuController(stage).getView());

        BedrijfController bedrijf = new BedrijfController(list);

        switchController(bedrijf);

        stage.setScene(new Scene(mainPane));


        stage.setTitle(this.TITLE);
        stage.setWidth(this.WIDTH);
        stage.setHeight(this.HEIGHT);
        stage.show();
    }

    /**
     * Handles Switching of controllers
     */
    public static void switchController(Controller controller) {
        mainPane.setCenter(controller.getView());
    }

    public static BedrijfDao getBedrijven() {
        return bedrijf;
    }

    public static PersoonDao getPersoon() {
        return persoon;
    }
}
