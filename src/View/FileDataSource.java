package View;

import java.io.*;
import java.util.ArrayList;

public class FileDataSource {
    final String path;

    public FileDataSource(String path) {
        this.path = path;
    }

    void saveToFile(ArrayList<Object[]> entities) throws IOException {
        ObjectOutputStream writer = null;
        try {
            writer = new ObjectOutputStream(new FileOutputStream(path));
            writer.writeObject(entities);
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    ArrayList<Object[]> readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream reader = null;
        try{
            reader = new ObjectInputStream(new FileInputStream(path));
            ArrayList<Object[]> entities = (ArrayList<Object[]>) reader.readObject();
            return entities;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
