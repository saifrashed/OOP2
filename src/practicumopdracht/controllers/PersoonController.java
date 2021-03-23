package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Bedrijf;
import practicumopdracht.models.Persoon;
import practicumopdracht.views.PersoonView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * Persoon Controller
 * <p>
 * In de controller worden de model en view
 * samengebracht om vervolgens business
 * logica toe te passen.
 */
public class PersoonController extends Controller {

    /**
     * Model & View declaraties
     */
    private PersoonView view;
    private Bedrijf bedrijfInBewerking;
    private ObservableList<Persoon> persoonObservableList;


    /**
     * Verschillende commando's binnen deze controller
     */
    private static final String CREATE_PERSOON = "create";
    private static final String DELETE_PERSOON = "delete";
    private static final String UPDATE_PERSOON = "update";
    private static final String READ_PERSOON = "read";
    private static final String SELECT_PERSOON = "select";

    /**
     * Constructor
     */
    public PersoonController(Bedrijf bedrijf) {
        view = new PersoonView();
        bedrijfInBewerking = bedrijf;
        persoonObservableList = FXCollections.observableList(MainApplication.getPersoon().getAllFor(bedrijfInBewerking));

        this.view.getBedrijvenComboField().setItems(FXCollections.observableArrayList(MainApplication.getBedrijven().getAll()));

        if (bedrijfInBewerking != null) {
            this.view.setPersonen(bedrijfInBewerking, persoonObservableList);
        }

        view.getSubmitBtn().setOnAction(e -> handleButtonClick(UPDATE_PERSOON));
        view.getDeleteBtn().setOnAction(e -> handleButtonClick(DELETE_PERSOON));
        view.getNieuwBtn().setOnAction(e -> handleButtonClick(CREATE_PERSOON));
        view.getReturnBtn().setOnAction(e -> handleButtonClick(READ_PERSOON));
        view.getListView().setOnMouseClicked(e -> handleButtonClick(SELECT_PERSOON));
    }

    /**
     * Regelt handelingen binnen de Persoon applicatie
     *
     * @param command de te verrichtte handeling
     */
    private void handleButtonClick(String command) {
        try {
            switch (command) {
                case CREATE_PERSOON:
                    this.createPersoon();
                    break;
                case DELETE_PERSOON:
                    this.deletePersoon();
                    break;
                case UPDATE_PERSOON:
                    this.updatePersoon();
                    break;
                case READ_PERSOON:
                    this.returnPersoon();
                    break;
                case SELECT_PERSOON:
                    this.selectPersoon();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Somthing went wrong in HandleButtonClick at command -> " + command + " " + e);
        }
    }

    /**
     * Toevoegen Bedrijf business logic
     */
    public void createPersoon() {
        if (validateFields()) {
            Persoon nieuwPersoon = new Persoon(
                    view.getPersoonNaamField().getText(),
                    view.getGeboortDatumField().getValue(),
                    view.getIsActiefField().isSelected(),
                    Double.parseDouble(view.getPersoonLengteField().getText()),
                    bedrijfInBewerking
            );

            MainApplication.getPersoon().addOrUpdate(nieuwPersoon);
            refreshList();
            clearFields();
        }
    }

    /**
     * Verwijderen Bedrijf business logic
     */
    public void deletePersoon() {
        if(hasSelectedPersoon()) {
            Optional<ButtonType> option = displayAlert("Verwijderen", "Weet u zeker dat u dit wilt verwijderen?", "CONFIRMATION");
            if (option.get() == ButtonType.OK) {
                MainApplication.getPersoon().remove((Persoon) view.getListView().getSelectionModel().getSelectedItem());
                refreshList();
            }
        }
    }

    /**
     * Aanpassen Bedrijf business logic
     */
    public void updatePersoon() {
        if(hasSelectedPersoon()) {

        }
    }

    /**
     * Uitlezen en navigeren naar detail pagina business logic
     */
    public void returnPersoon() {
        List<Bedrijf> list = MainApplication.getBedrijven().getAll();
        BedrijfController bedrijf = new BedrijfController(list);
        MainApplication.switchController(bedrijf);
    }

    public void selectPersoon() {
        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

        view.getPersoonNaamField().setText(persoonObservableList.get(selectedIndex).getNaam());
        view.getPersoonLengteField().setText(Double.toString(persoonObservableList.get(selectedIndex).getLengte()));
        view.getGeboortDatumField().setValue(persoonObservableList.get(selectedIndex).getGeboorteDatum());
        view.getIsActiefField().setSelected(persoonObservableList.get(selectedIndex).isWerkzaam());
    }

    /**
     * Valideren van velden en de melding weergeven
     *
     * @return of correct gevalideerd
     */
    private boolean validateFields() {
        StringBuilder string = new StringBuilder();
        string.append("De volgende fouten zijn gevonden: \n");

        if (view.getPersoonNaamField().getText().isBlank() || view.getPersoonLengteField().getText().isBlank()) {

            if (view.getPersoonNaamField().getText().isBlank()) {
                string.append("- Persoon naam is verplicht! \n");
            }

            if (view.getPersoonLengteField().getText().isBlank()) {
                string.append("- Persoon lengte is verplicht! \n");
            }

            if (view.getGeboortDatumField().getValue().isBefore(LocalDate.now())) {
                string.append("- Persoon geboortedatum moet voor huidige datum liggen! \n");
            }

            this.displayAlert("Opslaan", string.toString(), "WARNING");
            return false;
        } else {
            return true;
        }
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


    private void clearFields() {
        view.getPersoonNaamField().clear();
        view.getIsActiefField().setSelected(false);
        view.getPersoonLengteField().clear();
        view.getGeboortDatumField().getEditor().clear();
    }

    private void refreshList() {
        persoonObservableList = FXCollections.observableList(MainApplication.getPersoon().getAllFor(bedrijfInBewerking));
        view.setPersonen(bedrijfInBewerking, persoonObservableList);
    }

    /**
     * Controleert of een bedrijf is geselecteerd
     *
     * @return of bedrijf is geselecteerd met true of false
     */
    private boolean hasSelectedPersoon() {
        int selectedIndex = view.getListView().getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            return true;
        } else {
            this.displayAlert("Er ging wat mis", "U hebt geen persoon geselecteerd", "WARNING");
            return false;
        }
    }

    /**
     * Geeft view van Persoon terug
     * om weergegeven te worden in de applicatie
     *
     * @return Parent node
     */
    @Override
    public Parent getView() {
        return view.getRoot();
    }
}
