package practicumopdracht.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import practicumopdracht.models.Bedrijf;
import practicumopdracht.models.Persoon;

import java.util.List;

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

//    /**
//     * Menu bar
//     */
//    private MenuBar menuBar = new MenuBar();
//    private Menu fileItem = new Menu("Bestand");
//    private MenuItem fileSave = new MenuItem("Opslaan");
//    private MenuItem fileLoad = new MenuItem("Laden");
//    private MenuItem fileClose = new MenuItem("Afsluiten");
//    private Menu sortItem = new Menu("Sorteren");

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
    private final Label bedrijvenCombo = new Label("Bedrijf:");
    private final ComboBox<Bedrijf> bedrijvenComboField = new ComboBox<>();

    private final Label persoonNaam = new Label("Naam:");
    private final TextField persoonNaamField = new TextField();

    private final Label persoonLengte = new Label("Lengte:");
    private final TextField persoonLengteField = new TextField();

    private final Label geboorteDatum = new Label("Geboorte datum:");
    private final DatePicker geboortDatumField = new DatePicker();

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
//        // menu bar
//        fileItem.getItems().addAll(fileSave, fileLoad, fileClose);
//        menuBar.getMenus().addAll(fileItem, sortItem);
//        VBox MenuvBox = new VBox(menuBar);


        // Bedrijven comboBox
        HBox bedrijvenComboBox = new HBox();
        this.bedrijvenCombo.setPrefWidth(120);
        this.bedrijvenComboField.setPrefWidth(500);
        bedrijvenComboBox.getChildren().addAll(this.bedrijvenCombo, this.bedrijvenComboField);
        this.bedrijvenComboField.getSelectionModel().select(0);

        // Persoonnaam
        HBox persoonNaamBox = new HBox();
        this.persoonNaam.setPrefWidth(120);
        this.persoonNaamField.setPrefWidth(500);
        persoonNaamBox.getChildren().addAll(this.persoonNaam, this.persoonNaamField);

        // Persoonnaam
        HBox persoonLengteBox = new HBox();
        this.persoonLengte.setPrefWidth(120);
        this.persoonLengteField.setPrefWidth(500);
        persoonLengteBox.getChildren().addAll(this.persoonLengte, this.persoonLengteField);


        // persoon geboortedatum
        HBox geboorteDatumBox = new HBox();
        this.geboorteDatum.setPrefWidth(120);
        this.geboortDatumField.setPrefWidth(500);
        geboorteDatumBox.getChildren().addAll(this.geboorteDatum, this.geboortDatumField);

        // is actief checkbox
        HBox isActiefBox = new HBox();
        this.isActiefField.setPadding(new Insets(10, 0, 0, 120));
        isActiefBox.getChildren().add(this.isActiefField);

        // formulier container
        this.topForm.setPadding(new Insets(25, 10, 25, 10));
        this.topForm.setAlignment(Pos.CENTER_LEFT);
        this.topForm.getChildren().addAll(bedrijvenComboBox, persoonNaamBox, persoonLengteBox, geboorteDatumBox, isActiefBox);

        // actions sectie
        submitBtn.prefWidthProperty().bind(this.topForm.widthProperty());
        this.actions.getChildren().add(submitBtn);

        // list sectie
        this.listView.prefWidthProperty().bind(this.list.widthProperty());
        this.list.getChildren().add(this.listView);

        // Bottom actions gridpane
        GridPane gp = new GridPane();
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();

        col0.setPercentWidth(33);
        col1.setPercentWidth(33);
        col2.setPercentWidth(33);

        col0.setHalignment(HPos.CENTER);
        col1.setHalignment(HPos.CENTER);
        col2.setHalignment(HPos.CENTER);

        gp.getColumnConstraints().addAll(col0, col1, col2);
        gp.prefWidthProperty().bind(this.bottomActions.widthProperty());

        gp.add(this.nieuwBtn, 0, 0);
        gp.add(this.deleteBtn, 1, 0);
        gp.add(this.returnBtn, 2, 0);

        this.nieuwBtn.setMaxWidth(1000);
        this.deleteBtn.setMaxWidth(1000);
        this.returnBtn.setMaxWidth(1000);

        this.bottomActions.getChildren().addAll(gp);

        // root box sectie
        this.rootVbox.getChildren().addAll(this.topForm, this.actions, this.list, this.bottomActions);
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


    public void setBedrijf(Bedrijf bedrijf, List<Persoon> Personen) {

        this.getBedrijvenComboField().getSelectionModel().select(bedrijf);
        listView.getItems().clear();
        listView.getItems().addAll(Personen);
    }


    public void setPersoon(List<Persoon> personen) {
        this.listView.getItems().clear();
        this.listView.getItems().addAll(personen);
    }

    public ComboBox<Bedrijf> getBedrijvenComboField() {
        return bedrijvenComboField;
    }

    public TextField getPersoonNaamField() {
        return persoonNaamField;
    }

    public TextField getPersoonLengteField() {
        return persoonLengteField;
    }

    public DatePicker getGeboortDatumField() {
        return geboortDatumField;
    }

    public CheckBox getIsActiefField() {
        return isActiefField;
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
