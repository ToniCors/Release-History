package it.toni.releaseHistory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Microservice implements Serializable,ModelInterface {

    private String name;
    private List<String> branchs = new ArrayList<>();
    private List<Step> steps;
    private String note = "";

    @JsonIgnore
    @Override
    public boolean isDone() {
        boolean done = true;

        for (Step s : steps)
            done = done && s.isDone();

        return done;
    }
}
