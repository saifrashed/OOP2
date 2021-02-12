package practicumopdracht.controllers;

import practicumopdracht.models.Bedrijf;
import practicumopdracht.views.BedrijfView;

public class BedrijfController {
    private BedrijfView view;
    private Bedrijf bedrijf;

    public BedrijfController() {

        view = new BedrijfView();
        bedrijf = new Bedrijf();

        view.getSubmitBtn().setOnAction(actionEvent -> handleButtonClick());

    }

    private void handleButtonClick() {
        this.updateTellerView();
    }

    private void updateTellerView() {
        view.getListView().getItems().add("hello");
    }

    public BedrijfView getView() {
        return view;
    }
}
