package practicumopdracht.models;

import java.util.ArrayList;

public class Bedrijf {
    private String naam;
    private ArrayList<Persoon> personen = new ArrayList<Persoon>();

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
     * @param naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Haalt personen op van bedrijf
     * @return
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

    @Override
    public String toString() {
        return "Bedrijf{" +
                "naam='" + naam + '\'' +
                '}';
    };
}
