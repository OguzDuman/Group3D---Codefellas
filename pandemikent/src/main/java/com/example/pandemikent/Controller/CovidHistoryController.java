package com.example.pandemikent.Controller;

import com.example.pandemikent.Service.CovidHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class CovidHistoryController {
    @Autowired
    private CovidHistoryService covidInfo;

    @GetMapping("/vaccineHistory")
    public @ResponseBody Boolean displayCovidHistoryPage(@RequestParam String name) {
        // I don't understand why the method in the service class is returning a boolean. It should return string.
        return covidInfo.getCovidHistory(name);
    }
}
