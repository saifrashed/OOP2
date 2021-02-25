package practicumopdracht.controllers;

import javafx.scene.Parent;
import practicumopdracht.MainApplication;
import practicumopdracht.models.Persoon;
import practicumopdracht.views.PersoonView;

import java.util.ArrayList;


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
    private Persoon Persoon;
    private final ArrayList<Persoon> bedrijven = new ArrayList<>();

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
    public PersoonController() {
        view = new PersoonView();

        view.getSubmitBtn().setOnAction(e -> handleButtonClick(CREATE_PERSOON));
        view.getDeleteBtn().setOnAction(e -> handleButtonClick(DELETE_PERSOON));
        view.getNieuwBtn().setOnAction(e -> handleButtonClick(UPDATE_PERSOON));
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
                    this.createPersoonView();
                    break;
                case DELETE_PERSOON:
                    this.deletePersoonView();
                    break;
                case UPDATE_PERSOON:
                    this.updatePersoonView();
                    break;
                case READ_PERSOON:
                    this.returnPersoonView();
                    break;
                case SELECT_PERSOON:
                    this.selectPersoonView();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Somthing went wrong in HandleButtonClick at command -> " + command + " " + e);
        }
    }

    /**
     * Toevoegen Bedrijf business logic
     */
    public void createPersoonView() {
        // code
    }

    /**
     * Verwijderen Bedrijf business logic
     */
    public void deletePersoonView() {
        // code
    }

    /**
     * Aanpassen Bedrijf business logic
     */
    public void updatePersoonView() {
        // code
    }

    /**
     * Uitlezen en navigeren naar detail pagina business logic
     */
    public void returnPersoonView() {
        MainApplication.switchController(false);
    }

    public void selectPersoonView() {
        // code
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
