package practicumopdracht.controllers;

import javafx.scene.Parent;
import javafx.stage.Stage;
import practicumopdracht.MainApplication;
import practicumopdracht.data.BedrijfDao;
import practicumopdracht.data.PersoonDao;
import practicumopdracht.views.MenuView;

public class MenuController extends Controller{
    private MenuView view = new MenuView();

    public MenuController(Stage mainWindow){
        BedrijfDao bedrijf = MainApplication.getBedrijven();
        PersoonDao persoon = MainApplication.getPersoon();

        this.view.getSave().setOnAction(e -> {
            bedrijf.save();
            persoon.save();
        });

        this.view.getLoad().setOnAction(e -> {
            bedrijf.load();
            persoon.load();
        });

        this.view.getQuit().setOnAction(e -> {
            mainWindow.close();
        });
    }

    @Override
    public Parent getView() {
        return view.getRoot();
    }
}