package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Persoon;
import practicumopdracht.models.Bedrijf;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class TextPersoonDao extends PersoonDao {
    private File file = new File("persoon.txt");
    private BedrijfDao bedrijf = MainApplication.getBedrijven();

    @Override
    public boolean save() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            for (Persoon f : this.objects) {
                int bedrijfId = bedrijf.getIdFor(f.getHoortBij());

                writer.write(String.format("%s,%s,%s,%s,%s\n",
                        f.getNaam(), f.getGeboorteDatum(), f.isWerkzaam(), f.getLengte(), bedrijfId));
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

                int mandId = Integer.parseInt(parts[4]);
                Bedrijf bijbehorendeBedrijf = bedrijf.getById(mandId);

                Persoon f = new Persoon(parts[0], LocalDate.parse(parts[1]), Boolean.parseBoolean(parts[2]) , Double.parseDouble(parts[3]), bijbehorendeBedrijf);

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
