package practicumopdracht.comparators;

import practicumopdracht.models.Bedrijf;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class BedrijfNaamComparator implements Comparator<Bedrijf> {

    String sortType;

    public BedrijfNaamComparator(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Bedrijf o1, Bedrijf o2) {
        switch (sortType) {
            case "ASC":
                return o1.getNaam().compareToIgnoreCase(o2.getNaam());
            case "DESC":
                return -o1.getNaam().compareToIgnoreCase(o2.getNaam());
            default:
                return o1.getNaam().compareToIgnoreCase(o2.getNaam());
        }
    }
}
