package ru.blinov.csvparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.blinov.csvparser.dto.TopForms;
import ru.blinov.csvparser.dto.UserForms;
import ru.blinov.csvparser.dto.UserProgress;
import ru.blinov.csvparser.repository.UserProgressRepository;
import ru.blinov.csvparser.service.RecordService;

import java.util.*;

import static ru.blinov.csvparser.CsvparserApplication.CURRENT_TIME;

@Controller
@RequestMapping("/users")
public class RecordController {

    private RecordService recordService;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    // Это первое задание пункта 2
    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<UserForms> userList = recordService.showUsers(CURRENT_TIME-3600L, CURRENT_TIME);
        model.addAttribute("userList", userList);
        return "user-list";
    }

    // Это третье задание пункта 2
    @GetMapping("/showTopForms")
    public String showTopForms(Model model) {
        List<TopForms> topFormsList = recordService.showTopFiveForms();
        model.addAttribute("topFormsList", topFormsList);
        return "top-five-forms";
    }

    // Это второе задание пункта 2
    @GetMapping("/showUserProgress")
    public String showUserProgress(Model model) {
        final String eventID = "dszn%";

        // От закоментированного способа решил отказаться, т.к. много запросов к базе получим

//        List<String> uniqueUserList = recordService.showUniqueSsoIDByEventGroup(eventID);
//        List<UserProgress> userProgressList = new ArrayList<>();
//
//        for (String user: uniqueUserList) {
//            userProgressList.addAll(recordService.showUserProgress(user, eventID));
//        }

        // Про это прокомментировал в UserProgressRepository.
        List<UserProgressRepository.UserProgress> userProgressList = recordService.showUserProgress2(eventID);

        model.addAttribute("userProgressList", userProgressList);
        return "user-progress";
    }


}
