package ru.blinov.csvparser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.blinov.csvparser.dto.TopForms;
import ru.blinov.csvparser.dto.UserForms;
import ru.blinov.csvparser.dto.UserProgress;
import ru.blinov.csvparser.entity.Record;
import ru.blinov.csvparser.repository.RecordRepository;
import ru.blinov.csvparser.repository.TopFormsRepository;
import ru.blinov.csvparser.repository.UserFormsRepository;
import ru.blinov.csvparser.repository.UserProgressRepository;

import java.util.List;

@Service
public class RecordService {

    private RecordRepository recordRepository;
    private TopFormsRepository topFormsRepository;
    private UserFormsRepository userFormsRepository;
    private UserProgressRepository userProgressRepository;

    @Autowired
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Autowired
    public void setTopFormsRepository(TopFormsRepository topFormsRepository) {
        this.topFormsRepository = topFormsRepository;
    }

    @Autowired
    public void setUserFormsRepository(UserFormsRepository userFormsRepository) {
        this.userFormsRepository = userFormsRepository;
    }

    @Autowired
    public void setUserProgressRepository(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    public void addRecord(List<Record> recordList) {
        recordRepository.saveAll(recordList);
    }

    public List<UserForms> showUsers(Long time1, Long time2) {
        return userFormsRepository.findUserActivityByTimeStampBetween(time1, time2);
    }

    public List<String> showUniqueUsers(Long time1, Long time2) {
        return recordRepository.findUniqueSsoIDsByTimeStampBetween(time1, time2);
    }

    public List<TopForms> showTopFiveForms() {
        return topFormsRepository.findTopFiveForms(PageRequest.of(0, 5));
    }

    public List<Record> showAllRecordsByEyEventGroupContains(String string) {
        return recordRepository.findAllByEventGroupContains(string);
    }

    public List<String> showUniqueSsoIDByEventGroup(String eventGroup) {
        return recordRepository.findUniqueSsoIDsByEventGroupContains(eventGroup);
    }

    public List<UserProgressRepository.UserProgress> showUserProgress(String ssoID, String eventGroup) {
        return userProgressRepository.findUserProgressBySsoIDAAndEventGroupContains(ssoID, eventGroup, PageRequest.of(0, 1));
    }

    public List<UserProgressRepository.UserProgress> showUserProgress2(String eventGroup) {
        return userProgressRepository.findUserProgressBySsoIDAAndEventGroupContains2(eventGroup);
    }

}
