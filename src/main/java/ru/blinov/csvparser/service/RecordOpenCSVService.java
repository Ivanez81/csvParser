package ru.blinov.csvparser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.blinov.csvparser.entity.RecordOpenCSV;
import ru.blinov.csvparser.repository.RecordOpenCSVRepository;

@Service
public class RecordOpenCSVService {

    private RecordOpenCSVRepository recordOpenCSVRepository;

    @Autowired
    public void setRecordOpenCSVRepository(RecordOpenCSVRepository recordOpenCSVRepository) {
        this.recordOpenCSVRepository = recordOpenCSVRepository;
    }

    public void addRecordOpenCSV(RecordOpenCSV recordOpenCSV) {
        recordOpenCSVRepository.save(recordOpenCSV);
    }

}
