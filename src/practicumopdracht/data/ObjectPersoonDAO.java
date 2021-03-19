package practicumopdracht.data;

import practicumopdracht.models.Persoon;

import java.io.*;

public class ObjectPersoonDAO extends PersoonDao {

    private static final String FILENAME = "persoon.bin";

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

            for (int i = 0; i < aantalObjecten; i++) {
                Persoon persoon = (Persoon) objectInputStream.readObject();

                addOrUpdate(persoon);
                System.out.println(persoon.toString());
            }

            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return true;
    }
}
