package it.toni.releaseHistory.utils;

import it.toni.releaseHistory.model.Microservice;
import it.toni.releaseHistory.model.Release;
import it.toni.releaseHistory.model.Step;
import it.toni.releaseHistory.model.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    static String taskName = "SWECMS-4839";
    static String taskDescription = "gestione lingua";

    public static void main(String[] args) {

        System.out.println("Hello, World!");

//        System.out.println(DevFlow.buildStandardDevFlow().toString());

        System.out.println(buildRelease("0.4.0"));

        System.out.println(
                Step.builder().build());
    }

    public static Serializable createMock(){
        return buildRelease("0.4.0");
    }

    public static Release buildRelease(String name){
        Release r = new Release();
        r.setName(name);
        r.setTasks(buildTasks(taskName, taskDescription));
        return r;
    }

    private static List<Task> buildTasks(String name, String description) {

        List<Task> tasks = new ArrayList<>();

        Task t1 = new Task();
        t1.setName(name);
        t1.setDescription(description);
        t1.setMicroservices(buildMicroservices());

        tasks.add(t1);

        return tasks;
    }

    private static List<Microservice> buildMicroservices() {
        List<Microservice> microservices = new ArrayList<>();

        Microservice ms1 = new Microservice();
        ms1.setName("cms-ms-riconoscimenti");
        ms1.setSteps(Step.buildDevFlow());

        microservices.add(ms1);

        return microservices;
    }
}
