package practicumopdracht.data;

import practicumopdracht.models.Bedrijf;

import java.io.*;
import java.time.LocalDate;

/**
 * Class BinaryBedrijfDAO
 * <p>
 * Opslaan en inladen van Binary data om te gebruiken in de applicatie.
 */
public class BinaryBedrijfDAO extends BedrijfDao {

    private static final String FILENAME = "bedrijf.dat";

    /**
     * Regelt het opslaan van de  gegevens
     *
     * @return Boolean
     */
    @Override
    public boolean save() {
        File file = new File(FILENAME);

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
        ) {
            dataOutputStream.writeInt(objects.size());

            for (Bedrijf bedrijf : objects) {
                dataOutputStream.writeUTF(bedrijf.getNaam());
                dataOutputStream.writeUTF(bedrijf.getOmschrijving());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    /**
     * Regelt het inladen van gegevens
     *
     * @return Boolean
     */
    @Override
    public boolean load() {
        objects.clear();

        File file = new File(FILENAME);

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream)
        ) {
            int aantalObjecten = dataInputStream.readInt();

            for (int i = 0; i < aantalObjecten; i++) {
                String naam = dataInputStream.readUTF();
                String omschrijving = dataInputStream.readUTF();

                Bedrijf bedrijf = new Bedrijf(
                        naam, omschrijving
                );

                addOrUpdate(bedrijf);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }
}
