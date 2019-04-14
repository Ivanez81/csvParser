package ru.blinov.csvparser.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

// Эту сущность использовал для загрузки csv файла в базу при помощи OpenCSV,
// в дальнейшем не использовал, просто попробовал.

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ssdb2")
public class RecordOpenCSV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "ssoID")
    @CsvBindByName(column = "ssoID")
    private String ssoID;

    @Column(name = "ts")
    @CsvBindByName(column = "ts")
    private String timeStamp;

    @Column(name = "grp")
    @CsvBindByName(column = "grp")
    private String eventGroup;

    @Column(name = "type")
    @CsvBindByName(column = "type")
    private String eventType;

    @Column(name = "subtype")
    @CsvBindByName(column = "subtype")
    private String eventSubType;

    @Column(name = "url")
    @CsvBindByName(column = "url")
    private String url;

    @Column(name = "orgid")
    @CsvBindByName(column = "orgid")
    private String organizationID;

    @Column(name = "formid")
    @CsvBindByName(column = "formid")
    private String formID;

    @Column(name = "code")
    @CsvBindByName(column = "code")
    private String code;

    @Column(name = "ltpa")
    @CsvBindByName(column = "ltpa")
    private String sessionKey;

    @Column(name = "sudirresponse")
    @CsvBindByName(column = "sudirresponse")
    private String authResponse;

    @Column(name = "ymdh")
    @CsvBindByName(column = "ymdh")
    private String dateAndTime;

    @Override
    public String toString() {
        return "RecordOpenCSV{" +
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
