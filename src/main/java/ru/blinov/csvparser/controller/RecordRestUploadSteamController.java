package ru.blinov.csvparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.blinov.csvparser.entity.Record;
import ru.blinov.csvparser.service.RecordService;
import ru.blinov.csvparser.util.UploaderCSV;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecordRestUploadSteamController {

    private RecordService recordService;
    private UploaderCSV uploaderCSV;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @Autowired
    public void setUploaderCSV(UploaderCSV uploaderCSV) {
        this.uploaderCSV = uploaderCSV;
    }

    @GetMapping("/uploadCSV")
    public String uploadCSV() {

        long start = System.currentTimeMillis();

        List<Record> recordList = uploaderCSV.processInputFile();

        recordService.addRecord(recordList);

        long finish = System.currentTimeMillis();
        long result = finish - start;

        return "Time to upload: " + result + " ms";

    }

}
