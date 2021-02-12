package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class BedrijfView extends View {

    // app sections
    private VBox rootVbox = new VBox();
    private HBox topForm = new HBox();
    private HBox actions = new HBox();
    private HBox bottomActions = new HBox();
    // list
    private HBox list = new HBox();
    private ListView listView = new ListView();
    // action buttons
    private Button submitBtn = new Button("Opslaan");
    // bottom actions
    private Button nieuwBtn = new Button("Nieuw");
    private Button deleteBtn = new Button("Verwijderen");
    private Button detailsBtn = new Button("Bekijk details");
    // form
    private Label bedrijfNaam = new Label("Bedrijfs naam:");
    private TextField bedrijfNaamField = new TextField();

    /**
     * Constructor
     */
    public BedrijfView() {
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

        // top form sectie
        this.bedrijfNaam.setPrefWidth(90);
        this.bedrijfNaamField.setPrefWidth(530);
        this.topForm.setPadding(new Insets(25, 10, 25, 10));
        this.topForm.setAlignment(Pos.CENTER_LEFT);
        this.topForm.getChildren().addAll(bedrijfNaam, bedrijfNaamField);

        // actions sectie
        submitBtn.setPrefWidth(640);
        this.actions.getChildren().addAll(submitBtn);

        // list sectie
        this.listView.setPrefWidth(640);

        // bottom controls sectie
        this.nieuwBtn.setPrefWidth(213);
        this.deleteBtn.setPrefWidth(213);
        this.detailsBtn.setPrefWidth(213);
        this.bottomActions.getChildren().addAll(this.nieuwBtn, this.deleteBtn, this.detailsBtn);

        // root box sectie
        this.rootVbox.getChildren().addAll(MenuvBox, this.topForm, this.actions, this.list, this.bottomActions);
    }

    public ListView getListView() {
        return listView;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    @Override
    public Parent getRoot() {
        return rootVbox;
    }

}
