package ru.blinov.csvparser.util;

import org.springframework.stereotype.Component;
import ru.blinov.csvparser.entity.Record;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

// Это попробовал написать парсер для CSV.

@Component
public class UploaderCSV {

    public List<Record> processInputFile() {
        List<Record> inputList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(
                            ClassLoader.getSystemResourceAsStream("csv/test_case.csv")
                    ))
            );
            // Используется Stream, пропускается 1 строка, т.к. это Header, и далее размапливается все функцией ниже.
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return inputList;
    }

    // Этой функцией размапливаю csv файл.
    private Function<String, Record> mapToItem = (line) -> {

        // Это ставлю нужный сепаратор
        String[] parsedLine = line.split(";");

        Record record = new Record();

        record.setSsoID(parsedLine[0]);
        record.setTimeStamp(parseLong(parsedLine[1]));
        record.setEventGroup(parsedLine[2]);
        record.setEventType(parsedLine[3]);
        record.setEventSubType(parsedLine[4]);
        record.setUrl(parsedLine[5]);
        record.setOrganizationID(parsedLine[6]);
        record.setFormID(parsedLine[7]);
        record.setCode(parsedLine[8]);
        record.setSessionKey(parsedLine[9]);
        record.setAuthResponse(parsedLine[10]);
        record.setDateAndTime(parsedLine[11]);

        return record;
    };

}
