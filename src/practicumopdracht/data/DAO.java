package practicumopdracht.data;

import java.util.List;

/**
 * DAO interface
 *
 * @param <T> Type Object
 */
public interface DAO<T> {

    /**
     * Interface functie voor het ophalen van alle objecten
     *
     * @return List<T>
     */
    List<T> getAll();

    /**
     * Interface functie voor het toevoegen van een object
     *
     * @return void
     */
    void addOrUpdate(T item);

    /**
     * Interface functie voor het verwijderen van een object
     *
     * @return void
     */
    void remove(T item);

    /**
     * Interface functie voor het opslaan van ingevoerde gegevens
     *
     * @return boolean
     */
    boolean save();

    /**
     * Interface functie voor het inladen van opgeslagen gegevens
     *
     * @return void
     */
    boolean load();
}
