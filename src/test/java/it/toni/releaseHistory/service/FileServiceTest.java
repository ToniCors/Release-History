package it.toni.releaseHistory.service;


import it.toni.releaseHistory.utils.TestUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

class FileServiceTest {

    static final String filename="C:\\Toni\\WorkSpace\\Tools\\ReleaseHistory\\release_history.txt";

    @Test
    @Order(1)
    void save() {
        Serializable obj = TestUtils.buildRelease("name");
        FileService.save(filename,obj);
    }

    @Test
    @Order(2)
    void load() {
        Serializable obj = FileService.load(filename);
        System.out.println(obj.toString());
    }

    @Test
    void export() {
        Serializable obj = TestUtils.createMock();
        String s = FileService.export(obj);
        System.out.println(s);
    }
}