package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Persoon;

import java.io.*;

/**
 * Class ObjectPersoonDAO
 * <p>
 * Opslaan en inladen van Object data om te gebruiken in de applicatie.
 */
public class ObjectPersoonDAO extends PersoonDao {

    private static final String FILENAME = "persoon.bin";
    private final BedrijfDao bedrijf = MainApplication.getBedrijven();

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
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeInt(objects.size());

            for (Persoon persoon : objects) {
                objectOutputStream.writeObject(persoon);
                objectOutputStream.writeByte(bedrijf.getIdFor(persoon.getHoortBij()));
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
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            int aantalObjecten = objectInputStream.readInt();

            if (aantalObjecten > -1) {
                for (int i = 0; i < aantalObjecten; i++) {
                    Persoon persoon = (Persoon) objectInputStream.readObject();
                    persoon.setHoortBij(bedrijf.getById(objectInputStream.readByte()));

                    this.objects.add(persoon);
                }
            }

            fileInputStream.close();
            objectInputStream.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("Het bestand is niet gevonden");
        } catch (IOException |
                ClassNotFoundException e) {
            System.out.println("De klasse is niet gevonden");
            e.printStackTrace();
        }


        return true;
    }
}
