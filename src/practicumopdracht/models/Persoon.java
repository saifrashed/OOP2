package practicumopdracht.models;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * Model Persoon
 * <p>
 * Hier wordt de data voor een persoon toegevoegd, aangepast, verwijderd
 * of uitgelezen.
 */
public class Persoon implements Serializable {
    private final String naam;
    private final LocalDate geboorteDatum;
    private final boolean isWerkzaam;
    private final double lengte;
    private transient Bedrijf hoortBij;

    /**
     * Constructor Persoon
     *
     * @param naam          Naam van persoon
     * @param geboorteDatum Geboortedatum van persoon
     * @param isWerkzaam    Of persoon werkzaam is
     * @param lengte        Lengte van persoon
     * @param bedrijf       Behorende bedrijf van persoon
     */
    public Persoon(String naam, LocalDate geboorteDatum, boolean isWerkzaam, double lengte, Bedrijf bedrijf) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.isWerkzaam = isWerkzaam;
        this.lengte = lengte;
        this.hoortBij = bedrijf;
    }

    /**
     * Haalt naam op van persoon
     *
     * @return String
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Haalt geboortdatum op van persoon
     *
     * @return Localdate
     */
    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    /**
     * Haalt werkzaamheid op van persoon
     *
     * @return Boolean
     */
    public boolean isWerkzaam() {
        return isWerkzaam;
    }

    /**
     * Haalt lengte op van persoon
     *
     * @return Double
     */
    public double getLengte() {
        return lengte;
    }

    /**
     * Haalt bedrijf op van persoon
     *
     * @return Bedrijf
     */
    public Bedrijf getHoortBij() {
        return hoortBij;
    }

    /**
     * Stelt bedrijf in voor persoon
     *
     * @param hoortBij De behorende bedrijf model
     */
    public void setHoortBij(Bedrijf hoortBij) {
        this.hoortBij = hoortBij;
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
        string.append(geboorteDatum);
        string.append("\n");
        string.append(lengte);
        string.append("\n");

        if (isWerkzaam) {
            string.append("Werkzaam");
        } else {
            string.append("Niet werkzaam");
        }
        string.append("\n");

        return string.toString();
    }
}


