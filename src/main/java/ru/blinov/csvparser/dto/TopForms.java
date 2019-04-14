package ru.blinov.csvparser.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopForms {

    private String formID;
    private Long countFormID;

    public TopForms(String formID, Long countFormID) {
        this.formID = formID;
        this.countFormID = countFormID;
    }
}
