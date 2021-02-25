package practicumopdracht.controllers;

import javafx.scene.Parent;

/**
 * Abstract class Controller
 *
 * Bevat abstracte methodes voor Children Controllers
 */
public abstract class Controller {

    /**
     * Geeft Parent node terug om gebruikt te worden in de stage
     *
     * @return Parent node
     */
    public abstract Parent getView();
}
