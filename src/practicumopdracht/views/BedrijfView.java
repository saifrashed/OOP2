package practicumopdracht.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Parent;
import practicumopdracht.models.Bedrijf;

import java.util.List;

/**
 * Class BedrijfView
 * <p>
 * Creeërd een view voor bedrijven waarop
 * verschillende handelingen op verricht
 * kunnen worden.
 */
public class BedrijfView extends View {

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
    private final ListView<Bedrijf> listView = new ListView();

    /**
     * Action button nodes
     */
    private final Button submitBtn = new Button("Opslaan");

    /**
     * Onderzijde knoppen console nodes
     */
    private final Button nieuwBtn = new Button("Nieuw");
    private final Button deleteBtn = new Button("Verwijderen");
    private final Button readBtn = new Button("Bekijk details");

    /**
     * Formulier nodes
     */
    private final Label bedrijfNaam = new Label("Bedrijfs naam:");
    private final TextField bedrijfNaamField = new TextField();

    private final Label omschrijving = new Label("Bedrijf Omschrijving:");
    private final TextArea omschrijvingField = new TextArea();

    /**
     * Melding nodes
     */
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);


    /**
     * Constructor BedrijfView
     */
    public BedrijfView() {
        this.initializeRoot();
    }

    /**
     * View init
     */
    private void initializeRoot() {
        // top form sectie
        HBox bedrijfNaamBox = new HBox();
        this.bedrijfNaam.setPrefWidth(120);
        this.bedrijfNaamField.setPrefWidth(500);
        bedrijfNaamBox.getChildren().addAll(this.bedrijfNaam, this.bedrijfNaamField);

        HBox omschrijvingBox = new HBox();
        this.omschrijving.setPrefWidth(120);
        this.omschrijvingField.setPrefWidth(500);
        omschrijvingBox.getChildren().addAll(this.omschrijving, this.omschrijvingField);

        this.topForm.setPadding(new Insets(25, 10, 25, 10));
        this.topForm.setAlignment(Pos.CENTER_LEFT);
        this.topForm.getChildren().addAll(bedrijfNaamBox, omschrijvingBox);

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
        gp.add(this.readBtn, 2, 0);

        this.nieuwBtn.setMaxWidth(1000);
        this.deleteBtn.setMaxWidth(1000);
        this.readBtn.setMaxWidth(1000);

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
    public Button getReadBtn() {
        return readBtn;
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
        return bedrijfNaamField;
    }

    public TextArea getOmschrijvingField() {
        return omschrijvingField;
    }


    public void setBedrijven(List<Bedrijf> bedrijven) {
        this.listView.getItems().clear();
        this.listView.getItems().addAll(bedrijven);
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
