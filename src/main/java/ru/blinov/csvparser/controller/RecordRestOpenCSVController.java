package ru.blinov.csvparser.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.blinov.csvparser.entity.RecordOpenCSV;
import ru.blinov.csvparser.service.RecordOpenCSVService;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class RecordRestOpenCSVController {

    private RecordOpenCSVService recordOpenCSVService;

    @Autowired
    public void setRecordOpenCSVService(RecordOpenCSVService recordOpenCSVService) {
        this.recordOpenCSVService = recordOpenCSVService;
    }

    @GetMapping("/uploadOpenCSV")
    public String uploadCSV() throws FileNotFoundException {

        long start = System.currentTimeMillis();

        List<RecordOpenCSV> resultList = new CsvToBeanBuilder<RecordOpenCSV>(
                new InputStreamReader(
                        Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("csv/test.csv"))
                ))
                .withSeparator(';')
                .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                .withType(RecordOpenCSV.class)
                .build()
                .parse();

        resultList.forEach(recordOpenCSVService::addRecordOpenCSV);

        long finish = System.currentTimeMillis();
        long res = finish - start;

        return "Time to upload: " + res + " ms";

    }

}
