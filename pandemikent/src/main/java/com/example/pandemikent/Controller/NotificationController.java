package com.example.pandemikent.Controller;

import com.example.pandemikent.Service.CovidNotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationController {

    @Autowired
    private CovidNotificationService covidNotificationService;

    @GetMapping("/notificationsPage")
    public String displayNotificationPage(@RequestParam("userId") String userId, Model theModel) {
        covidNotificationService.notifyCovidSituation(userId);
        //List<String> classes = classService.listUserClasses(userId); No idea what is meant in implementation report, no clue
      //  theModel.addAttribute("notifications", classes);
        return "listNotifications";
    }

    @GetMapping("/weeklyReport")
    public String publishWeeklyReport(Model theModel) {
        String report = covidNotificationService.createWeeklyReport();
        theModel.addAttribute("report", report);
        return "listReport";
    }

}