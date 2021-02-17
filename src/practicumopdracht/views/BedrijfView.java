package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import practicumopdracht.models.Bedrijf;

/**
 * Class BedrijfView
 *
 * Creeërd een view voor bedrijven waarop
 * verschillende handelingen op verricht
 * kunnen worden.
 */
public class BedrijfView extends View {

    /**
     * Essentiële container nodes
     */
    private final VBox rootVbox = new VBox();
    private final HBox topForm = new HBox();
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
    private final Button getReadBtn = new Button("Bekijk details");

    /**
     * Formulier nodes
     */
    private final Label bedrijfNaam = new Label("Bedrijfs naam:");
    private final TextField bedrijfNaamField = new TextField();

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
        this.actions.getChildren().add(submitBtn);

        // list sectie
        this.listView.setPrefWidth(640);
        this.list.getChildren().add(this.listView);

        // bottom controls sectie
        this.nieuwBtn.setPrefWidth(213);
        this.deleteBtn.setPrefWidth(213);
        this.getReadBtn.setPrefWidth(213);
        this.bottomActions.getChildren().addAll(this.nieuwBtn, this.deleteBtn, this.getReadBtn);

        // root box sectie
        this.rootVbox.getChildren().addAll(MenuvBox, this.topForm, this.actions, this.list, this.bottomActions);
    }

    /**
     * Haalt lijst op
     * @return ListView Node
     */
    public ListView getListView() {
        return listView;
    }

    /**
     * Haalt opslaan knop op
     * @return Button Node
     */
    public Button getSubmitBtn() {
        return submitBtn;
    }

    /**
     * Haalt verwijder knop op
     * @return Button Node
     */
    public Button getDeleteBtn() {
        return deleteBtn;
    }

    /**
     * Haalt Meer lezen knop op
     * @return Button Node
     */
    public Button getReadBtn() {
        return getReadBtn;
    }

    /**
     * Haalt Nieuw knop op
     * @return Button Node
     */
    public Button getNieuwBtn() {
        return nieuwBtn;
    }

    /**
     * Haalt bedrijf tekstveld op
     * @return TextFieLD Node
     */
    public TextField getBedrijfNaamField() {
        return bedrijfNaamField;
    }

    /**
     * Haalt alert op
     * @return alert Node
     */
    public Alert getAlert() { return alert; }

    /**
     * Haalt de view op
     * @return Parent node
     */
    @Override
    public Parent getRoot() {
        return rootVbox;
    }

}
