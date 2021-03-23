package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Bedrijf;
import practicumopdracht.models.Persoon;

import java.io.*;

public class ObjectPersoonDAO extends PersoonDao {

    private static final String FILENAME = "persoon.bin";
    private BedrijfDao bedrijf = MainApplication.getBedrijven();

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
            }

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

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

                    System.out.println(persoon.getHoortBij());
                    System.out.println(bedrijf.getById(0));

                    for (Bedrijf bedrijf : bedrijf.getAll()) {
                        if (persoon.getHoortBij().getNaam().equals(bedrijf.getNaam())) {
                            persoon.setHoortBij(bedrijf);
                            this.objects.add(persoon);
                        }
                    }
                }
            }

            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Het bestand is niet gevonden");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("De klasse is niet gevonden");
            e.printStackTrace();
        }


        return true;
    }
}
