package practicumopdracht.data;

import practicumopdracht.models.Persoon;
import practicumopdracht.models.Bedrijf;

import java.util.ArrayList;
import java.util.List;

public abstract class PersoonDao implements DAO<Persoon> {
    protected List<Persoon> objects = new ArrayList<>();

    public List<Persoon> getAllFor(Bedrijf m){

        List<Persoon> result = new ArrayList<>();
        for(Persoon f: objects){
            if(f.getHoortBij() == m){
                result.add(f);
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
        if(!objects.contains(item)){
            objects.add(item);
        }
    }

    @Override
    public void remove(Persoon item) {
        objects.remove(item);
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();
}
