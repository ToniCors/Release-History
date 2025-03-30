package it.toni.releaseHistory.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum StepTypeEnum implements Serializable {

    SVIL,
    GIT,
    CICD,
    DEV,
    TEST,
    DONE


}
