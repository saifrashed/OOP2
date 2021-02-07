package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BedrijfView implements View {
    @Override
    public void getRoot(Stage stage) {

        VBox rootVbox = new VBox();
        HBox topForm = new HBox();
        HBox actions = new HBox();
        HBox bottomActions = new HBox();


        // menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Bestand");
        Menu menu2 = new Menu("Sorteren");
        menuBar.getMenus().addAll(menu1, menu2);
        VBox MenuvBox = new VBox(menuBar);


        // start form
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));


        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(25);
        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(5);
        ColumnConstraints col3Constraints = new ColumnConstraints();
        col3Constraints.setPercentWidth(70);
        grid.getColumnConstraints().addAll(col1Constraints, col2Constraints, col3Constraints);


        // username
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 0, 20, 1 );

        TextField userTextField = new TextField();
        grid.add(userTextField, 15, 0, 100, 1);


        Label userPw = new Label("User Name:");
        grid.add(userPw, 0, 1, 20, 1 );

        TextField userPwField = new TextField();
        grid.add(userPwField, 15, 1, 100, 1);

        // end form

        // submit
        Button submitBtn = new Button("Opslaan");
        submitBtn.setPrefWidth(640);
        actions.getChildren().addAll(submitBtn);

        // list
        HBox list = new HBox();
        ListView listView = new ListView();

        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");

        topForm.getChildren().add(grid);
        listView.setPrefWidth(640);
        list.getChildren().add(listView);

        // bottom actions
        Button btn1 = new Button("Nieuw");
        Button btn2 = new Button("Verwijderen");
        Button btn3 = new Button("Bekijk details");

        btn1.setPrefWidth(213);
        btn2.setPrefWidth(213);
        btn3.setPrefWidth(213);

        bottomActions.getChildren().addAll(btn1, btn2, btn3);

        // brining everything thogether
        rootVbox.getChildren().addAll(MenuvBox, topForm, actions, list, bottomActions);

        Scene scene = new Scene(rootVbox);
        stage.setScene(scene);
    }
}
