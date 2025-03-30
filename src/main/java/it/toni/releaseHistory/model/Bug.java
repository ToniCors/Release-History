package it.toni.releaseHistory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bug implements Serializable,ModelInterface {

    private String name;
    private List<Microservice> microservices = new ArrayList<>();

    @Override
    public boolean isDone() {
        boolean done = true;

        for (Microservice m : microservices)
            done = done && m.isDone();

        return done;
    }
}
