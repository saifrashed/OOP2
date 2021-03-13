package practicumopdracht.data;

import practicumopdracht.models.Bedrijf;

public class FakeBedrijfDao extends BedrijfDao {
    @Override
    public boolean save() {
        return true;
    }

    @Override
    public boolean load() {
        objects.add(new Bedrijf("Tupperware", "yasss"));
        objects.add(new Bedrijf("Hema", "Yass"));
        return true;
    }
}
