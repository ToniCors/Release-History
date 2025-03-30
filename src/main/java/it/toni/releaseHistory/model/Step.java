package it.toni.releaseHistory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Step implements Serializable, ModelInterface {

    private StepTypeEnum type;
    private boolean isDone;
    private String note;

    public static List<Step> buildDevFlow() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step(StepTypeEnum.SVIL,false,""));
        steps.add(new Step(StepTypeEnum.GIT,false,""));
        steps.add(new Step(StepTypeEnum.CICD,false,""));
        steps.add(new Step(StepTypeEnum.DEV,false,""));
        steps.add(new Step(StepTypeEnum.TEST,false,""));
        steps.add(new Step(StepTypeEnum.DONE,false,""));
        return steps;
    }
}
