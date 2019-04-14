package ru.blinov.csvparser.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

public class UserProgress {

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

    @Getter
    @Setter
    private String eventGroup;

    @Getter
    @Setter
    private String eventSubType;

    public Date getDate() {
        return date;
    }

    public UserProgress(String ssoID, String formID, Long timeStamp, String eventGroup, String eventSubType) {
        this.ssoID = ssoID;
        this.formID = formID;
        this.timeStamp = timeStamp;
        this.eventGroup = eventGroup;
        this.eventSubType = eventSubType;
        this.date = Date.from(Instant.ofEpochSecond(timeStamp));
    }
}
