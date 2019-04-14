package ru.blinov.csvparser.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

public class UserForms {

    @Getter
    @Setter
    private String ssoID;

    @Getter
    @Setter
    private String formID;

    @Getter
    @Setter
    private Long timeStamp;

    private Date date;

    public Date getDate() {
        return date;
    }

    public UserForms(String ssoID, String formID, Long timeStamp) {
        this.ssoID = ssoID;
        this.formID = formID;
        this.timeStamp = timeStamp;
        this.date = Date.from(Instant.ofEpochSecond(timeStamp));
    }
}
