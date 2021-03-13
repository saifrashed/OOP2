package practicumopdracht.data;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();
    void addOrUpdate(T item);
    void remove(T item);
    boolean save();
    boolean load();
}
