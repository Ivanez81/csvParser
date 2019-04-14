package ru.blinov.csvparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class CsvparserApplication {

    public static final Long CURRENT_TIME = 1499815678L;

    public static void main(String[] args) {
        SpringApplication.run(CsvparserApplication.class, args);

        Date testDate = Date.from(Instant.ofEpochSecond(CURRENT_TIME));
        LocalDateTime testLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(CURRENT_TIME), ZoneId.systemDefault());

        System.out.println(testDate);
        System.out.println(testLocalDateTime);

    }

}
