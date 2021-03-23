package practicumopdracht.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Bedrijf
 * <p>
 * Hier wordt de data voor een bedrijf
 * toegevoegd, aangepast, verwijderd
 * of uitgelezen
 */
public class Bedrijf {
    private String naam;
    private String omschrijving;

    /**
     * Constructor Bedrijf
     *
     * @param naam Naam van het bedrijf
     */
    public Bedrijf(String naam, String omschrijving) {
        this.naam = naam;
        this.omschrijving = omschrijving;
    }

    /**
     * Haalt naam op van bedrijf
     *
     * @return
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Stelt naam in van bedrijf
     *
     * @param naam Naam van het bedrijf
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }


    /**
     * Haalt omschrijving op van bedrijf
     *
     * @return omschrijving van bedrijf
     */
    public String getOmschrijving() {
        return omschrijving;
    }

    /**
     * Stelt omschrijving in van bedrijf
     *
     * @param omschrijving omschrijving van het bedrijf
     */
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    
    /**
     * Geeft een string representatie weer
     *
     * @return Een string met informatie over dit klasse
     */
    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        string.append(naam);
        string.append("\n");
        string.append(omschrijving);
        string.append("\n");

        return string.toString();
    }

}
