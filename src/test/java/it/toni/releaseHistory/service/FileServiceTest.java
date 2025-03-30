package it.toni.releaseHistory.service;


import it.toni.releaseHistory.model.Release;
import it.toni.releaseHistory.utils.TestUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

class FileServiceTest {

    static final String filename = "D:\\Workspace\\workspaceSPRING\\ReleaseHistory\\src\\test\\resources\\release_history.txt";
    static final String filenameJson = "D:\\Workspace\\workspaceSPRING\\ReleaseHistory\\src\\test\\resources\\release_history.json";

    @Test
    @Order(1)
    void save() {
        Serializable obj = TestUtils.buildRelease("name");
        FileService.save(filename, obj);
    }

    @Test
    @Order(2)
    void load() {
        Serializable obj = FileService.load(filename);
        System.out.println(obj.toString());
    }

    @Test
    void exportJson() throws IOException {
        Release obj1 = (Release) TestUtils.createMock("0.4.0");
        Release obj2 = (Release) TestUtils.createMock("0.5.0");
        FileService.exportJson(filenameJson, List.of(obj1,obj2));
    }

    @Test
    void importJson() throws IOException {
        List<Release> r = FileService.importJson(filenameJson);
        System.out.println(r);
    }
}