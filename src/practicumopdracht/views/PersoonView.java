package practicumopdracht.views;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Parent;
import practicumopdracht.models.Bedrijf;
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
    private final VBox bottomActions = new VBox();

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
     * Sorteer buttons
     */
    private final ToggleGroup toggleGroup = new ToggleGroup();
    private final RadioButton sorteerAZRadioButton = new RadioButton("Type #1 (A-Z)");
    private final RadioButton sorteerZARadioButton = new RadioButton("Type #2 (Z-A)");
    private final RadioButton sorteerLengteAscRadioButton = new RadioButton("Type #1 Lengte (ASC)");
    private final RadioButton sorteerLengteDescRadioButton = new RadioButton("Type #2 Lengte (DESC)");

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
        actions.setPadding(new Insets(10, 10, 10, 10));
        this.actions.getChildren().add(submitBtn);

        // list sectie
        this.listView.prefWidthProperty().bind(this.list.widthProperty());
        this.list.getChildren().add(this.listView);

        // link to toggle group
        sorteerAZRadioButton.setToggleGroup(toggleGroup);
        sorteerZARadioButton.setToggleGroup(toggleGroup);
        sorteerLengteAscRadioButton.setToggleGroup(toggleGroup);
        sorteerLengteDescRadioButton.setToggleGroup(toggleGroup);

        // Bottom actions gridpanes

        // sort gridpane


        GridPane gpSort = new GridPane();
        ColumnConstraints colSort0 = new ColumnConstraints();
        ColumnConstraints colSort1 = new ColumnConstraints();
        ColumnConstraints colSort2 = new ColumnConstraints();
        ColumnConstraints colSort3 = new ColumnConstraints();

        colSort0.setPercentWidth(25);
        colSort1.setPercentWidth(25);
        colSort2.setPercentWidth(25);
        colSort3.setPercentWidth(25);

        colSort0.setHalignment(HPos.CENTER);
        colSort1.setHalignment(HPos.CENTER);
        colSort2.setHalignment(HPos.CENTER);
        colSort3.setHalignment(HPos.CENTER);

        gpSort.getColumnConstraints().addAll(colSort0, colSort1, colSort2, colSort3);
        gpSort.prefWidthProperty().bind(this.bottomActions.widthProperty());

        gpSort.setHgap(20);
        gpSort.setVgap(20);
        gpSort.setPadding(new Insets(10, 10, 10, 10));

        gpSort.add(sorteerAZRadioButton, 0, 0);
        gpSort.add(sorteerZARadioButton, 1, 0);
        gpSort.add(sorteerLengteAscRadioButton, 2, 0);
        gpSort.add(sorteerLengteDescRadioButton, 3, 0);

        // buttons gridpane
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

        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(10, 10, 10, 10));

        this.nieuwBtn.setMaxWidth(1000);
        this.deleteBtn.setMaxWidth(1000);
        this.returnBtn.setMaxWidth(1000);

        gp.add(this.nieuwBtn, 0, 1);
        gp.add(this.deleteBtn, 1, 1);
        gp.add(this.returnBtn, 2, 1);

        this.bottomActions.getChildren().addAll(gpSort, gp);

        // root box sectie
        this.rootVbox.getChildren().addAll(this.topForm, this.actions, this.list, this.bottomActions);
    }

    /**
     * Stel lijst in van personen en selecteerd des betreffende bedrijf
     *
     * @param bedrijf
     * @param personen
     */
    public void setPersonen(Bedrijf bedrijf, ObservableList<Persoon> personen) {
        this.getBedrijvenComboField().getSelectionModel().select(bedrijf);
        listView.getItems().clear();
        listView.getItems().addAll(personen);
    }

    /**
     * Selectie voor bedrijven
     *
     * @return ComboBox node
     */
    public ComboBox<Bedrijf> getBedrijvenComboField() {
        return bedrijvenComboField;
    }

    /**
     * Haalt naam veld op
     *
     * @return TextField node
     */
    public TextField getPersoonNaamField() {
        return persoonNaamField;
    }

    /**
     * Haalt lengte veld op
     *
     * @return TextField node
     */
    public TextField getPersoonLengteField() {
        return persoonLengteField;
    }

    /**
     * geboortedatum veld op
     *
     * @return DatePicker node
     */
    public DatePicker getGeboortDatumField() {
        return geboortDatumField;
    }

    /**
     * haalt werkzaamheid veld op
     *
     * @return CheckBox node
     */
    public CheckBox getIsActiefField() {
        return isActiefField;
    }

    /**
     * Haalt lijst op
     *
     * @return ListView Node
     */
    public ListView<Persoon> getListView() {
        return listView;
    }

    /**
     * Sorteer radio buttons group
     *
     * @return ToggleGroup node
     */
    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    /**
     * Omhoog sorteren op naam radio knop
     *
     * @return RadioButton Node
     */
    public RadioButton getSorteerAZRadioButton() {
        return sorteerAZRadioButton;
    }

    /**
     * Omlaag sorteren op naam radio knop
     *
     * @return RadioButton Node
     */
    public RadioButton getSorteerZARadioButton() {
        return sorteerZARadioButton;
    }

    /**
     * Omhoog sorteren op lengte radio knop
     *
     * @return RadioButton Node
     */
    public RadioButton getSorteerLengteAscRadioButton() {
        return sorteerLengteAscRadioButton;
    }

    /**
     * Omlaag sorteren op lengte radio knop
     *
     * @return RadioButton Node
     */
    public RadioButton getSorteerLengteDescRadioButton() {
        return sorteerLengteDescRadioButton;
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
