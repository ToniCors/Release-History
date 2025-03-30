package it.toni.releaseHistory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release implements Serializable,ModelInterface {

    private String name;
    private List<Task> tasks;

    @Override
    public boolean isDone() {
        boolean done = true;

        for (Task t : tasks)
            done = done && t.isDone();

        return done;
    }

}
