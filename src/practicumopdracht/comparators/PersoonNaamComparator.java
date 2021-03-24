package practicumopdracht.comparators;

import practicumopdracht.models.Persoon;

import java.util.Comparator;

/**
 * Comparator voor persoonnaam
 */
public class PersoonNaamComparator implements Comparator<Persoon> {
    String sortType;

    public PersoonNaamComparator(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Persoon o1, Persoon o2) {
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
