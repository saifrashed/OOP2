package practicumopdracht.comparators;

import practicumopdracht.models.Persoon;
import java.util.Comparator;

public class PersoonLengteComparator implements Comparator<Persoon> {
    String sortType;

    public PersoonLengteComparator(String sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Persoon o1, Persoon o2) {
        switch (sortType) {
            case "ASC":
                return Double.compare(o1.getLengte(), o2.getLengte());
            case "DESC":
                return -Double.compare(o1.getLengte(), o2.getLengte());
            default:
                return Double.compare(o1.getLengte(), o2.getLengte());
        }
    }
}
