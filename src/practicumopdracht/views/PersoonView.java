package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import practicumopdracht.models.Persoon;

/**
 * Class Persoonview
 * <p>
 * Creeërd een view voor bedrijven waarop
 * verschillende handelingen op verricht
 * kunnen worden.
 */
public class PersoonView extends View {

    /**
     * Essentiële container nodes
     */
    private final VBox rootVbox = new VBox();
    private final VBox topForm = new VBox();
    private final HBox actions = new HBox();
    private final HBox bottomActions = new HBox();

    /**
     * Lijst nodes
     */
    private final HBox list = new HBox();
    private final ListView<Persoon> listView = new ListView();

    /**
     * Action button nodes
     */
    private final Button submitBtn = new Button("Opslaan");

    /**
     * Onderzijde knoppen console nodes
     */
    private final Button nieuwBtn = new Button("Nieuw");
    private final Button deleteBtn = new Button("Verwijderen");
    private final Button returnBtn = new Button("Ga terug");

    /**
     * Formulier nodes
     */
    private final HBox bedrijvenComboBox = new HBox();
    private final Label bedrijvenCombo = new Label("Bedrijf:");
    private final ComboBox bedrijvenComboField = new ComboBox();

    private final HBox persoonNaamBox = new HBox();
    private final Label persoonNaam = new Label("Naam:");
    private final TextField persoonNaamField = new TextField();

    private final HBox geboorteDatumBox = new HBox();
    private final Label geboorteDatum = new Label("Geboorte datum:");
    private final DatePicker geboortDatumField = new DatePicker();

    private final HBox isActiefBox = new HBox();
    private final CheckBox isActiefField = new CheckBox("Is Actief");

    /**
     * Melding nodes
     */
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);


    /**
     * Constructor BedrijfView
     */
    public PersoonView() {
        this.initializeRoot();
    }

    /**
     * View init
     */
    private void initializeRoot() {
        // menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Bestand");
        Menu menu2 = new Menu("Sorteren");

        menuBar.getMenus().addAll(menu1, menu2);
        VBox MenuvBox = new VBox(menuBar);


        // Bedrijven comboBox
        this.bedrijvenCombo.setPrefWidth(120);
        this.bedrijvenComboField.setPrefWidth(500);
        this.bedrijvenComboBox.getChildren().addAll(this.bedrijvenCombo, this.bedrijvenComboField);
        this.bedrijvenComboField.getItems().addAll(
                "HvA",
                "UvA",
                "ROC"
        );
        this.bedrijvenComboField.getSelectionModel().select(0);

        // Persoonnaam
        this.persoonNaam.setPrefWidth(120);
        this.persoonNaamField.setPrefWidth(500);
        this.persoonNaamBox.getChildren().addAll(this.persoonNaam, this.persoonNaamField);

        // persoon geboortedatum
        this.geboorteDatum.setPrefWidth(120);
        this.geboortDatumField.setPrefWidth(500);
        this.geboorteDatumBox.getChildren().addAll(this.geboorteDatum, this.geboortDatumField);

        // is actief checkbox
        this.isActiefField.setPadding(new Insets(10, 0, 0, 120));
        this.isActiefBox.getChildren().add(this.isActiefField);

        // formulier container
        this.topForm.setPadding(new Insets(25, 10, 25, 10));
        this.topForm.setAlignment(Pos.CENTER_LEFT);
        this.topForm.getChildren().addAll(this.bedrijvenComboBox, this.persoonNaamBox, this.geboorteDatumBox, this.isActiefBox);

        // actions sectie
        submitBtn.setPrefWidth(640);
        this.actions.getChildren().add(submitBtn);

        // list sectie
        this.listView.setPrefWidth(640);
        this.list.getChildren().add(this.listView);

        // bottom controls sectie
        this.nieuwBtn.setPrefWidth(213);
        this.deleteBtn.setPrefWidth(213);
        this.returnBtn.setPrefWidth(213);
        this.bottomActions.getChildren().addAll(this.nieuwBtn, this.deleteBtn, this.returnBtn);

        // root box sectie
        this.rootVbox.getChildren().addAll(MenuvBox, this.topForm, this.actions, this.list, this.bottomActions);
    }

    /**
     * Haalt lijst op
     *
     * @return ListView Node
     */
    public ListView getListView() {
        return listView;
    }

    /**
     * Haalt opslaan knop op
     *
     * @return Button Node
     */
    public Button getSubmitBtn() {
        return submitBtn;
    }

    /**
     * Haalt verwijder knop op
     *
     * @return Button Node
     */
    public Button getDeleteBtn() {
        return deleteBtn;
    }

    /**
     * Haalt Meer lezen knop op
     *
     * @return Button Node
     */
    public Button getReturnBtn() {
        return returnBtn;
    }

    /**
     * Haalt Nieuw knop op
     *
     * @return Button Node
     */
    public Button getNieuwBtn() {
        return nieuwBtn;
    }

    /**
     * Haalt bedrijf tekstveld op
     *
     * @return TextFieLD Node
     */
    public TextField getBedrijfNaamField() {
        return persoonNaamField;
    }

    /**
     * Haalt alert op
     *
     * @return alert Node
     */
    public Alert getAlert() {
        return alert;
    }

    /**
     * Haalt de view op
     *
     * @return Parent node
     */
    @Override
    public Parent getRoot() {
        return rootVbox;
    }

}
