package exercises;

import java.util.List;

public class DatabaseAccessObject<T> {
    public void saveToDb(T object) {
        throw new UnsupportedOperationException("Tried to access the database");
    }
    public List<T> loadFromDb() {
        throw new UnsupportedOperationException("Tried to access the database");
    }
}
