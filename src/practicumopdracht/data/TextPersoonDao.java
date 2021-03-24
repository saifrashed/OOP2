package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Persoon;
import practicumopdracht.models.Bedrijf;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Class TextBedrijfDao
 * <p>
 * Opslaan en inladen van text data om te gebruiken in de applicatie.
 */
public class TextPersoonDao extends PersoonDao {
    private final File file = new File("persoon.txt");
    private final BedrijfDao bedrijf = MainApplication.getBedrijven();

    /**
     * Regelt het opslaan van de  gegevens
     *
     * @return Boolean
     */
    @Override
    public boolean save() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            for (Persoon persoon : this.objects) {
                int bedrijfId = bedrijf.getIdFor(persoon.getHoortBij());

                writer.write(String.format("%s,%s,%s,%s,%s\n",
                        persoon.getNaam(), persoon.getGeboorteDatum(), persoon.isWerkzaam(), persoon.getLengte(), bedrijfId));
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Regelt het inladen van gegevens
     *
     * @return Boolean
     */
    @Override
    public boolean load() {
        if (!file.exists()) {
            return true;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String rawLine = scanner.nextLine();
                String[] parts = rawLine.split(",");

                Bedrijf bijbehorendeBedrijf = bedrijf.getById(Integer.parseInt(parts[4]));

                Persoon f = new Persoon(parts[0], LocalDate.parse(parts[1]), Boolean.parseBoolean(parts[2]), Double.parseDouble(parts[3]), bijbehorendeBedrijf);

                this.objects.add(f);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            scanner.close();
        }
    }
}
