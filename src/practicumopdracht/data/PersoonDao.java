package practicumopdracht.data;

import practicumopdracht.models.Bedrijf;
import practicumopdracht.models.Persoon;

import java.util.ArrayList;
import java.util.List;

public abstract class PersoonDao implements DAO<Persoon> {
    protected List<Persoon> objects = new ArrayList<>();

    public List<Persoon> getAllFor(Bedrijf bedrijf) {
        List<Persoon> result = new ArrayList<>();
        for (Persoon persoon : objects) {
            if (persoon.getHoortBij() == bedrijf) {
                result.add(persoon);
            }
        }

        return result;
    }

    @Override
    public List<Persoon> getAll() {
        return new ArrayList<>(objects);
    }

    @Override
    public void addOrUpdate(Persoon item) {
        if (!objects.contains(item)) {
            objects.add(item);
        }
    }

    @Override
    public void remove(Persoon item) {
        objects.remove(item);
    }

    public void removeAll() {
        objects.removeAll(objects);
    }

    public void removeAllFor(Bedrijf bedrijf) {
        for (Persoon persoon : objects) {
            if (persoon.getHoortBij() == bedrijf) {
                objects.remove(persoon);
            }
        }
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();
}
