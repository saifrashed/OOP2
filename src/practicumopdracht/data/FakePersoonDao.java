package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Persoon;
import practicumopdracht.models.Bedrijf;

import java.time.LocalDate;

public class FakePersoonDao extends PersoonDao {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {

        Bedrijf eerste = MainApplication.getBedrijven().getById(0);
        Bedrijf tweede = MainApplication.getBedrijven().getById(1);

        objects.add(new Persoon("Kees",  LocalDate.of(2001, 02, 17), true, 1.78, eerste));
        objects.add(new Persoon("Kees",LocalDate.of(2001, 02, 17), true, 1.78, tweede));
        objects.add(new Persoon("Kees", LocalDate.of(2001, 02, 17), true, 1.78, eerste));

        objects.add(new Persoon("Kees", LocalDate.of(2001, 02, 17), true, 1.78, tweede));
        objects.add(new Persoon("Kees", LocalDate.of(2001, 02, 17), true, 1.78, eerste));

        return false;
    }
}
