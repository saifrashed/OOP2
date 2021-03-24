package practicumopdracht.comparators;

import practicumopdracht.models.Bedrijf;

import java.util.Comparator;

public class BedrijfOmschrijvingComparator implements Comparator<Bedrijf> {

    String sortType;

    public BedrijfOmschrijvingComparator(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Bedrijf o1, Bedrijf o2) {
        switch (sortType) {
            case "ASC":
                return o1.getOmschrijving().compareToIgnoreCase(o2.getOmschrijving());
            case "DESC":
                return -o1.getOmschrijving().compareToIgnoreCase(o2.getOmschrijving());
            default:
                return o1.getOmschrijving().compareToIgnoreCase(o2.getOmschrijving());
        }
    }
}
