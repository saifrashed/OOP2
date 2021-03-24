package practicumopdracht.data;

import practicumopdracht.models.Bedrijf;

import java.util.ArrayList;
import java.util.List;

public abstract class BedrijfDao implements DAO<Bedrijf> {
    protected List<Bedrijf> objects = new ArrayList<>();

    @Override
    public List<Bedrijf> getAll() {
        return new ArrayList<>(objects);
    }

    @Override
    public void addOrUpdate(Bedrijf item) {
        if (!objects.contains(item)) {
            objects.add(item);
        }
    }

    @Override
    public void remove(Bedrijf item) {
        objects.remove(item);
    }

    public void removeAll() {
        objects.removeAll(objects);
    }

    public int getIdFor(Bedrijf bedrijf) {
        return this.objects.indexOf(bedrijf);
    }

    public Bedrijf getById(int i) {
        return this.objects.get(i);
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();
}
