package it.toni.releaseHistory.service;

import org.json.JSONObject;

import java.io.*;

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

    public static String export(Serializable object) {
        JSONObject jsonObject = new JSONObject(object);
        return jsonObject.toString();
    }

}
