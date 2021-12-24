package com.example.pandemikent.Controller;

import java.util.List;

import com.example.pandemikent.Model.Vaccine;
import com.example.pandemikent.Service.CovidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VaccineController {
    @Autowired
    private CovidHistoryService vaccineInfo;

    @GetMapping("/displayVaccineHistory")
    public @ResponseBody List<Vaccine> displayVaccineTrackerPage(@RequestParam String name) {
        // url of the page
        
        return vaccineInfo.getVaccineHistory(name); // add this method 
    }

    @PostMapping("/addVaccineCertificate")
    public @ResponseBody String displayAddVaccineCertificatePage() {
        // url of the page
        return "the page name";
    }

    @PostMapping("/addCertificate")
    public @ResponseBody String displayAddVaccineCertificate() {
        // url of the page
        return "the page name";
    }
}
