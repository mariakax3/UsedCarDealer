package View;

import java.io.IOException;
import java.util.ArrayList;

public class FleetRepository {
    final FileDataSource dataSource;

    public FleetRepository(FileDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveToFile(ArrayList<Object[]> entities) throws CannotSaveToFileException {
        try{
            dataSource.saveToFile(entities);
        } catch (IOException e) {
            throw new CannotSaveToFileException();
        }
    }

    ArrayList<Object[]> readFromFile() {
        try{
            return dataSource.readFromFile();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Object[]>();
        }
    }
}
