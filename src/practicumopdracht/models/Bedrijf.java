package practicumopdracht.models;

import java.util.ArrayList;

/**
 * Class Bedrijf
 *
 * Hier wordt de data voor een bedrijf
 * toegevoegd, aangepast, verwijderd
 * of uitgelezen
 */
public class Bedrijf {
    private String naam;
    private final ArrayList<Persoon> personen = new ArrayList<Persoon>();

    /**
     * Constructor Bedrijf
     * @param naam Naam van het bedrijf
     */
    public Bedrijf(String naam) {
        this.naam = naam;
    }

    /**
     * Haalt naam op van bedrijf
     * @return
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Stelt naam in van bedrijf
     * @param naam Naam van het bedrijf
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Haalt personen op van bedrijf
     * @return ArrayList Personen
     */
    public ArrayList<Persoon> getPersonen() {
        return personen;
    }

    /**
     * Voegt persoon toe aan bedrijf
     * @param persoon persoon en bijhorende gegevens
     */
    public void addPersonen(Persoon persoon) {
        this.personen.add(persoon);
    }

    /**
     * Geeft een string representatie weer
     * @return Een string met informatie over dit klasse
     */
    @Override
    public String toString() {
        return "Bedrijf{" +
                "naam='" + naam + '\'' +
                '}';
    }

}
