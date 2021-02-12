package practicumopdracht.controllers;

import practicumopdracht.models.Bedrijf;
import practicumopdracht.views.BedrijfView;
import java.util.ArrayList;


/**
 * Bedrijf Controller
 */
public class BedrijfController {

    // essentials
    private BedrijfView view;
    private Bedrijf bedrijf;
    private ArrayList<Bedrijf> bedrijven = new ArrayList<>();

    // commandos
    private static final String CREATE_BEDRIJF = "create";
    private static final String DELETE_BEDRIJF = "delete";
    private static final String UPDATE_BEDRIJF = "update";
    private static final String READ_BEDRIJF = "read";
    private static final String SELECT_BEDRIJF = "select";

    /**
     * Constructor
     */
    public BedrijfController() {
        view = new BedrijfView();

        view.getSubmitBtn().setOnAction(e -> handleButtonClick(UPDATE_BEDRIJF));
        view.getDeleteBtn().setOnAction(e -> handleButtonClick(DELETE_BEDRIJF));
        view.getNieuwBtn().setOnAction(e -> handleButtonClick(CREATE_BEDRIJF));
        view.getReadBtn().setOnAction(e -> handleButtonClick(READ_BEDRIJF));
        view.getListView().setOnMouseClicked(e -> handleButtonClick(SELECT_BEDRIJF));
    }

    /**
     * Regelt handelingen binnen de bedrijf applicatie
     * @param command de te verrichtte handeling
     */
    private void handleButtonClick(String command) {
        try {
            switch (command) {
                case CREATE_BEDRIJF:
                    this.createBedrijfView();
                    break;
                case DELETE_BEDRIJF:
                    this.deleteBedrijfView();
                    break;
                case UPDATE_BEDRIJF:
                    this.updateBedrijfView();
                    break;
                case READ_BEDRIJF:
                    this.readBedrijfView();
                    break;
                case SELECT_BEDRIJF:
                    this.selectBedrijfView();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Somthing went wrong in HandleButtonClick at command -> " + command + " " + e);
        }
    }


    /**
     * Create Bedrijf business logic
     */
    private void createBedrijfView() {
        if (!view.getBedrijfNaamField().getText().isEmpty()) {
            bedrijven.add(new Bedrijf(view.getBedrijfNaamField().getText()));
            view.getListView().getItems().add(new Bedrijf(view.getBedrijfNaamField().getText()).getNaam());
        } else {
            view.getAlert().setTitle("Melding");
            view.getAlert().setHeaderText("Oops, er ging wat mis.");
            view.getAlert().setContentText("Er zijn een aantal velden leeg. Vul deze in.");

            view.getAlert().showAndWait();
        }
    }

    /**
     * Create Bedrijf business logic
     */
    private void deleteBedrijfView() {

        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

        bedrijven.remove(selectedIndex);
        view.getListView().getItems().remove(selectedIndex);
    }

    /**
     * Aanpassen Bedrijf business logic
     */
    private void updateBedrijfView() {
        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();
        String bedrijfsNaamInput = view.getBedrijfNaamField().getText();

        if (selectedIndex >= 0) {
            view.getListView().getItems().set(selectedIndex, bedrijfsNaamInput);
        } else {
            view.getAlert().setTitle("Melding");
            view.getAlert().setHeaderText("Oops, er ging wat mis.");
            view.getAlert().setContentText("U hebt geen bedrijf geselecteerd");

            view.getAlert().showAndWait();
        }
    }

    /**
     * Uitlezen Bedrijf business logic
     */
    private void readBedrijfView() {
        view.getAlert().setTitle("Melding");
        view.getAlert().setHeaderText("Oops, er ging wat mis.");
        view.getAlert().setContentText("Dit scherm is nog niet gebouwd");
        view.getAlert().showAndWait();
    }

    /**
     * Selecteren Bedrijf business logic
     */
    private void selectBedrijfView() {
        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();
        Object selectedValue = view.getListView().getItems().get(selectedIndex);

        view.getBedrijfNaamField().setText(selectedValue.toString());
    }

    /**
     * Bedrijf root
     */
    public BedrijfView getView() {
        return view;
    }
}
