package practicumopdracht.controllers;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Bedrijf;
import practicumopdracht.views.BedrijfView;

import java.util.List;
import java.util.Optional;


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
    private BedrijfView view;

    /**
     * Verschillende commando's binnen deze controller
     */
    private static final String RESET_BEDRIJF = "reset";
    private static final String DELETE_BEDRIJF = "delete";
    private static final String UPDATE_BEDRIJF = "update";
    private static final String READ_BEDRIJF = "read";
    private static final String SELECT_BEDRIJF = "select";

    /**
     * Constructor
     */
    public BedrijfController(List<Bedrijf> bedrijf) {
        view = new BedrijfView();
        view.setBedrijven(bedrijf);

        view.getSubmitBtn().setOnAction(e -> handleButtonClick(UPDATE_BEDRIJF));
        view.getDeleteBtn().setOnAction(e -> handleButtonClick(DELETE_BEDRIJF));
        view.getNieuwBtn().setOnAction(e -> handleButtonClick(RESET_BEDRIJF));
        view.getReadBtn().setOnAction(e -> handleButtonClick(READ_BEDRIJF));
        view.getListView().setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                handleButtonClick(READ_BEDRIJF);
            } else {
                handleButtonClick(SELECT_BEDRIJF);
            }
        });
    }

    /**
     * Regelt handelingen binnen de bedrijf applicatie
     *
     * @param command de te verrichtte handeling
     */
    private void handleButtonClick(String command) {
        try {
            switch (command) {
                case RESET_BEDRIJF:
                    this.resetBedrijf();
                    break;
                case DELETE_BEDRIJF:
                    this.deleteBedrijf();
                    break;
                case UPDATE_BEDRIJF:
                    this.updateBedrijf();
                    break;
                case READ_BEDRIJF:
                    this.readBedrijf();
                    break;
                case SELECT_BEDRIJF:
                    this.selectBedrijf();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Somthing went wrong in HandleButtonClick at command -> " + command + " " + e);
        }
    }

    /**
     * Reset Bedrijf business logic
     */
    private void resetBedrijf() {
        clearFields();
        MainApplication.getPersoon().removeAll();
        MainApplication.getBedrijven().removeAll();
        view.setBedrijven(MainApplication.getBedrijven().getAll());
    }

    /**
     * Verwijderen Bedrijf business logic
     */
    private void deleteBedrijf() {
        if (hasSelectedBedrijf()) {

            Optional<ButtonType> option = displayAlert("Verwijderen", "Weet u zeker dat u dit wilt verwijderen?", "CONFIRMATION");

            if (option.get() == ButtonType.OK) {
                int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

                MainApplication.getPersoon().getAllFor(MainApplication.getBedrijven().getById(selectedIndex));
                MainApplication.getBedrijven().remove(MainApplication.getBedrijven().getById(selectedIndex));
                view.setBedrijven(MainApplication.getBedrijven().getAll());
            }
        }
    }

    /**
     * Aanpassen Bedrijf business logic
     */
    private void updateBedrijf() {
        if (validateFields()) {
            int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

            if (selectedIndex > -1) {
                String bedrijfsNaamInput = view.getBedrijfNaamField().getText();
                String omschrijving = view.getOmschrijvingField().getText();

                MainApplication.getBedrijven().getById(selectedIndex).setNaam(bedrijfsNaamInput);
                MainApplication.getBedrijven().getById(selectedIndex).setOmschrijving(omschrijving);
                view.setBedrijven(MainApplication.getBedrijven().getAll());
                clearFields();
            } else {
                MainApplication.getBedrijven().addOrUpdate(new Bedrijf(view.getBedrijfNaamField().getText(), view.getOmschrijvingField().getText()));
                view.setBedrijven(MainApplication.getBedrijven().getAll());
                clearFields();
            }
        }
    }

    /**
     * Uitlezen en navigeren naar detail pagina business logic
     */
    private void readBedrijf() {
        if (hasSelectedBedrijf()) {
            int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

            PersoonController persoon = new PersoonController(MainApplication.getBedrijven().getById(selectedIndex));
            MainApplication.switchController(persoon);
        }
    }

    /**
     * Selecteren Bedrijf business logic
     */
    private void selectBedrijf() {
        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

        view.getBedrijfNaamField().setText(MainApplication.getBedrijven().getById(selectedIndex).getNaam());
        view.getOmschrijvingField().setText(MainApplication.getBedrijven().getById(selectedIndex).getOmschrijving());
    }


    /**
     * Valideren van velden en de melding weergeven
     *
     * @return of correct gevalideerd
     */
    private boolean validateFields() {
        StringBuilder string = new StringBuilder();
        string.append("De volgende fouten zijn gevonden: \n");

        if (view.getBedrijfNaamField().getText().isBlank() || view.getOmschrijvingField().getText().isBlank()) {

            if (view.getBedrijfNaamField().getText().isBlank()) {
                string.append("- Bedrijf naam is verplicht! \n");
            }

            if (view.getOmschrijvingField().getText().isBlank()) {
                string.append("- Bedrijf omschrijving is verplicht! \n");
            }

            displayAlert("Opslaan", string.toString(), "WARNING");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Controleert of een bedrijf is geselecteerd
     *
     * @return of bedrijf is geselecteerd met true of false
     */
    private boolean hasSelectedBedrijf() {
        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            return true;
        } else {
            displayAlert("Er ging wat mis", "U hebt geen bedrijf geselecteerd", "WARNING");
            return false;
        }
    }

    private void clearFields() {
        view.getBedrijfNaamField().clear();
        view.getOmschrijvingField().clear();
    }

    /**
     * Weergeven van een melding
     *
     * @param message Het bericht dat in de melding staat
     * @return
     */
    private Optional<ButtonType> displayAlert(String title, String message, String type) {
        switch (type) {
            case "ERROR":
                view.getAlert().setAlertType(Alert.AlertType.ERROR);
                break;
            case "WARNING":
                view.getAlert().setAlertType(Alert.AlertType.WARNING);
                break;
            case "INFORMATION":
                view.getAlert().setAlertType(Alert.AlertType.INFORMATION);
                break;
            case "CONFIRMATION":
                view.getAlert().setAlertType(Alert.AlertType.CONFIRMATION);
                break;
        }

        view.getAlert().setTitle("Melding");
        view.getAlert().setHeaderText(title);
        view.getAlert().setContentText(message);
        return view.getAlert().showAndWait();
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
