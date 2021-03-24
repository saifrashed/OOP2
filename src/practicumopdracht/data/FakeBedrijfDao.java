package practicumopdracht.data;

import practicumopdracht.models.Bedrijf;


/**
 * Class FakeBedrijfDao
 * <p>
 * Creëren van nepdata om te gebruiken in de applicatie voor test doeleinden.
 */
public class FakeBedrijfDao extends BedrijfDao {

    /**
     * Regelt het opslaan van de  gegevens
     *
     * @return Boolean
     */
    @Override
    public boolean save() {
        return true;
    }

    /**
     * Regelt het inladen van gegevens
     *
     * @return Boolean
     */
    @Override
    public boolean load() {
        objects.add(new Bedrijf("Tupperware", "yasss"));
        objects.add(new Bedrijf("Hema", "Yass"));
        return true;
    }
}
