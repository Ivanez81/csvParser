package ru.blinov.csvparser.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

// Эту сущность использую для загрузки в базу прои помощи моего парсера UploaderCSV, а также для всех остальных манипуляций потом.
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ssdb4")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "ssoID")
    private String ssoID;

    @Column(name = "ts")
    private Long timeStamp;

    @Column(name = "grp")
    private String eventGroup;

    @Column(name = "type")
    private String eventType;

    @Column(name = "subtype")
    private String eventSubType;

    @Column(name = "url")
    private String url;

    @Column(name = "orgid")
    private String organizationID;

    @Column(name = "formid")
    private String formID;

    @Column(name = "code")
    private String code;

    @Column(name = "ltpa")
    private String sessionKey;

    @Column(name = "sudirresponse")
    private String authResponse;

    @Column(name = "ymdh")
    private String dateAndTime;

    @Override
    public String toString() {
        return "Record{" +
                "ssoID='" + ssoID + '\'' +
                ", timeStamp=" + timeStamp +
                ", eventGroup='" + eventGroup + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventSubType='" + eventSubType + '\'' +
                ", url='" + url + '\'' +
                ", organizationID='" + organizationID + '\'' +
                ", formID='" + formID + '\'' +
                ", code='" + code + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", authResponse='" + authResponse + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                '}';
    }

}
