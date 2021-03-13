package practicumopdracht.views;

import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuView extends View {

    private MenuItem save = new MenuItem("Save");
    private MenuItem load = new MenuItem("Load");
    private MenuItem quit = new MenuItem("Afsluiten");

    private final MenuBar root;

    public MenuView() {
        Menu saveLoad = new Menu("Bestand", null, save, load, quit);
        this.root = new MenuBar(saveLoad);
    }

    public MenuItem getSave() {
        return save;
    }

    public MenuItem getLoad() {
        return load;
    }

    public MenuItem getQuit() {
        return quit;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
