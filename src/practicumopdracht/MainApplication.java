package practicumopdracht;

import javafx.application.Application;
import javafx.stage.Stage;
import practicumopdracht.views.BedrijfView;
import practicumopdracht.views.PersoonView;

public class MainApplication extends Application {

    private final String TITLE = String.format("Practicumopdracht OOP2 - %s", Main.studentNaam);
    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    @Override
    public void start(Stage stage) {
        if(!Main.launchedFromMain) {
            System.err.println("Je moet deze applicatie opstarten vanuit de Main-class, niet de MainApplication-class!");
            System.exit(1337);
            return;
        }


        BedrijfView bedrijfView = new BedrijfView();
        PersoonView persoonView = new PersoonView();

        bedrijfView.getRoot(stage);

        stage.setTitle(this.TITLE);
        stage.setWidth(this.WIDTH);
        stage.setHeight(this.HEIGHT);
        stage.show();
    }
}
