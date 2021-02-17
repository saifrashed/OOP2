package practicumopdracht.controllers;

import javafx.scene.Parent;
import practicumopdracht.models.Bedrijf;
import practicumopdracht.views.BedrijfView;

import java.util.ArrayList;


/**
 * Bedrijf Controller
 * <p>
 * In de controller worden de model en view
 * samengebracht om vervolgens business
 * logica toe te passen.
 */
public class BedrijfController extends Controller {

    /**
     * Model & View declaraties
     */
    private final BedrijfView view;
    private Bedrijf bedrijf;
    private final ArrayList<Bedrijf> bedrijven = new ArrayList<>();

    /**
     * Verschillende commando's binnen deze controller
     */
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
     *
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
            this.displayAlert("Er zijn een aantal velden leeg. Vul deze in.");
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
            this.displayAlert("U hebt geen bedrijf geselecteerd");
        }
    }

    /**
     * Uitlezen Bedrijf business logic
     */
    private void readBedrijfView() {
        this.displayAlert("Dit scherm is nog niet gebouwd");
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
     * Weergeven van een melding
     *
     * @param message Het bericht dat in de melding staat
     */
    private void displayAlert(String message) {
        view.getAlert().setTitle("Melding");
        view.getAlert().setHeaderText("Oops, er ging wat mis.");
        view.getAlert().setContentText(message);
        view.getAlert().showAndWait();
    }

    /**
     * Geeft view van Bedrijf terug
     * om weergegeven te worden in de applicatie
     *
     * @return Parent node
     */
    @Override
    public Parent getView() {
        return view.getRoot();
    }
}
