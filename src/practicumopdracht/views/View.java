package practicumopdracht.views;

import javafx.scene.Parent;

/**
 * Abstract class View
 * <p>
 * Bevat abstracte methodes voor Children Views
 */
public abstract class View {

    /**
     * Geeft Parent node terug om gebruikt te worden in de controller
     *
     * @return Parent node
     */
    public abstract Parent getRoot();
}


