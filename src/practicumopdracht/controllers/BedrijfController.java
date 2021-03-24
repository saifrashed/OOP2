package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.BedrijfNaamComparator;
import practicumopdracht.comparators.BedrijfOmschrijvingComparator;
import practicumopdracht.models.Bedrijf;
import practicumopdracht.views.BedrijfView;

import java.util.Comparator;
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
    private ObservableList<Bedrijf> bedrijfObservableList;

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
    public BedrijfController() {
        view = new BedrijfView();
        bedrijfObservableList = FXCollections.observableList(MainApplication.getBedrijven().getAll());
        view.setBedrijven(bedrijfObservableList);

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

        view.getSave().setOnAction(e -> menuSave());
        view.getLoad().setOnAction(e -> menuLoad());
        view.getQuit().setOnAction(e -> menuQuit());
        view.getSortAZ().setOnAction(e -> menuSortAZ());
        view.getSortZA().setOnAction(e -> menuSortZA());

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
        MainApplication.getPersoon().removeAll();
        MainApplication.getBedrijven().removeAll();
        clearFields();
        refreshList();
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
                refreshList();
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
                refreshList();
                clearFields();
            } else {
                MainApplication.getBedrijven().addOrUpdate(new Bedrijf(view.getBedrijfNaamField().getText(), view.getOmschrijvingField().getText()));
                refreshList();
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

    /**
     * opslaan van gegevens logica
     */
    private void menuSave() {
        MainApplication.getBedrijven().save();
        MainApplication.getPersoon().save();
        refreshList();
    }

    /**
     * Inladen van gegevens logica
     */
    private void menuLoad() {
        MainApplication.getBedrijven().load();
        MainApplication.getPersoon().load();
        refreshList();
    }

    /**
     * Applicatie sluiten
     */
    private void menuQuit() {
        MainApplication.getPrimaryStage().close();
    }

    /**
     * Omhoog sorteren logica
     */
    private void menuSortAZ() {
        Comparator<Bedrijf> sort = new BedrijfNaamComparator("ASC").thenComparing(new BedrijfOmschrijvingComparator("ASC"));
        bedrijfObservableList.sort(sort);
        updateSortedList();
    }

    /**
     * Omlaag sorteren logica
     */
    private void menuSortZA() {
        Comparator<Bedrijf> sort = new BedrijfNaamComparator("DESC").thenComparing(new BedrijfOmschrijvingComparator("DESC"));
        bedrijfObservableList.sort(sort);
        updateSortedList();
    }

    /**
     * Schoont velden op
     */
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
     * Werkt de lijst bij
     */
    private void refreshList() {
        bedrijfObservableList = FXCollections.observableList(MainApplication.getBedrijven().getAll());
        view.setBedrijven(bedrijfObservableList);
    }

    /**
     * Werkt de lijst bij voor sortering
     */
    private void updateSortedList() {
        view.setBedrijven(bedrijfObservableList);
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
