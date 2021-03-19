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
public class Bedrijf implements Serializable {
    private String naam;
    private String omschrijving;
    private final ArrayList<Persoon> personen = new ArrayList<Persoon>();

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
     * Haalt personen op van bedrijf
     *
     * @return ArrayList Personen
     */
    public ArrayList<Persoon> getPersonen() {
        return personen;
    }

    /**
     * Voegt persoon toe aan bedrijf
     *
     * @param persoon persoon en bijhorende gegevens
     */
    public void addPersonen(Persoon persoon) {
        this.personen.add(persoon);
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
