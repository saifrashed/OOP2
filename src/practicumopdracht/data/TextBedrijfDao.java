package practicumopdracht.data;

import practicumopdracht.models.Bedrijf;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextBedrijfDao extends BedrijfDao {

    private final File file = new File("bedrijven.txt");

    @Override
    public boolean save() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            for (Bedrijf b : this.objects) {
                writer.write(String.format("%s,%s\n",
                        b.getNaam(), b.getOmschrijving()));
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

                Bedrijf b = new Bedrijf(parts[0], parts[1]);

                this.objects.add(b);
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
