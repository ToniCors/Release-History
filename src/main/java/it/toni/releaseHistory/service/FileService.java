package it.toni.releaseHistory.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.toni.releaseHistory.model.Release;

import java.io.*;
import java.util.List;

public class FileService {

    public static void save(String filename, Serializable object) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static Serializable load(String filename) {

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            Serializable object = (Serializable) in.readObject();

            in.close();
            file.close();
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void exportJson(String filename, List<Release> object) throws IOException {
        new ObjectMapper().writeValue(new File(filename), object);
    }

    public static List<Release> importJson(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), new TypeReference<>() {
        });
    }

}
