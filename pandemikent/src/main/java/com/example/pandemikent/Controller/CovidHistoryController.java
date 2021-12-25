package com.example.pandemikent.Controller;

import com.example.pandemikent.Service.CovidHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class CovidHistoryController {
    @Autowired
    private CovidHistoryService covidInfo;

    @GetMapping("/vaccineHistory")
    public @ResponseBody
    List<String> displayCovidHistoryPage(@RequestParam String userID) {
        // I don't understand why the method in the service class is returning a boolean. It should return string.
        return covidInfo.getCovidHistory(userID);
    }

    @PostMapping("/addHistory")
    public @ResponseBody
    String addCovidHistoryPage(@RequestParam String userID, @RequestParam String history) {
        if (covidInfo.addCovidHistory(userID, history)) {
            return "Saved";
        }
        return "Failed";

    }
}
