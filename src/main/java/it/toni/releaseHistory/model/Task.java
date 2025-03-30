package it.toni.releaseHistory.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable,ModelInterface {

    private String name;
    private String description;
    private List<Microservice> microservices = new ArrayList<>();
    private List<Bug> bugs = new ArrayList<>();
    private String note = "";

    @JsonIgnore
    @Override
    public boolean isDone() {
        boolean done = true;

        for (Microservice m : microservices)
            done = done && m.isDone();

        return done;
    }
}
