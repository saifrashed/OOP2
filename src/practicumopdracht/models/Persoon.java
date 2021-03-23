package practicumopdracht.models;

import java.time.LocalDate;
import java.io.Serializable;


public class Persoon implements Serializable {
    private String naam;
    private LocalDate geboorteDatum;
    private boolean isWerkzaam;
    private double lengte;
    private transient Bedrijf hoortBij;

    public Persoon(String naam, LocalDate geboorteDatum, boolean isWerkzaam, double lengte, Bedrijf bedrijf) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.isWerkzaam = isWerkzaam;
        this.lengte = lengte;
        this.hoortBij = bedrijf;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public boolean isWerkzaam() {
        return isWerkzaam;
    }

    public void setWerkzaam(boolean werkzaam) {
        isWerkzaam = werkzaam;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public Bedrijf getHoortBij() {
        return hoortBij;
    }

    public void setHoortBij(Bedrijf hoortBij) {
        this.hoortBij = hoortBij;
    }

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


