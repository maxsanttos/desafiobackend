package com.desafio.gerenciador.domain.tasks;

import lombok.Getter;

@Getter
public enum Status {

    PENDING("pending"),
    COMPLETED("completed"),
    IN_PROGRESS("in progress");

    private String label;

    Status(String label){
        this.label = label;
    } 

}
