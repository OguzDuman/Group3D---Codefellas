package com.example.pandemikent.Controller;

import com.example.pandemikent.Model.Class;
import com.example.pandemikent.Model.PCR;
import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.StudentRepository;
import com.example.pandemikent.Repo.UserProfileRepository;
import com.example.pandemikent.Service.CovidHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class CovidHistoryController {
    @Autowired
    private CovidHistoryService covidInfo;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/CovidHistory")
    public String displayCovidHistoryPage(@RequestParam String userID, Model theModel) {
        theModel.addAttribute("history", covidInfo.getCovidHistory(userID));
        UserProfile user = userProfileRepository.findById(userID).get();
        theModel.addAttribute("user", user);
        String access = covidInfo.findAccessStatus(userID);
  	  	theModel.addAttribute("access", access);
        return "CovidHistory";
    }
    
    @GetMapping("/quarantinePage")
    public String displayQuarantinePage(@RequestParam String userID, Model theModel) {
    	UserProfile user = userProfileRepository.findById(userID).get();
        theModel.addAttribute("user", user);
        String access = covidInfo.findAccessStatus(userID);
  	  	theModel.addAttribute("access", access);
        return "QuarantineTracker";
    }
    
    @GetMapping("/HESTrackerPage")
    public String displayHESTrackerPage(@RequestParam String userID, Model theModel) {
    	UserProfile user = userProfileRepository.findById(userID).get();
        theModel.addAttribute("user", user);
        String access = covidInfo.findAccessStatus(userID);
  	  	theModel.addAttribute("access", access);
        return "HESCodeTracker";
    }

    @PostMapping("/addHistory")
    public @ResponseBody
    String addCovidHistoryPage(@RequestParam String userID, @RequestParam String history) {
        if (covidInfo.addCovidHistory(userID, history)) {  // We need to probably use models, not sure how!
            return "Saved";
        }
        return "Failed";
    }

//    @GetMapping("/campusAccessStatus")
//    public @ResponseBody
//    String displayCampusAccessStatus(@RequestParam String userID, Model theModel) {
//        theModel.addAttribute("accessStatus", covidInfo.findAccessStatus(userID));
//        UserProfile user = userProfileRepository.findById(userID).get();
//        theModel.addAttribute("user", covidInfo.findAccessStatus(userID));
//        return "accessStatus";
//    }
    
//    @GetMapping("/campusAccessStatus")
//    public @ResponseBody Boolean displayCampusAccessStatus(@RequestParam("userID") String userID) {
//        System.out.println("hey");
//        return covidInfo.findAccessStatus(userID);
//    }

    @GetMapping("/displayPCR")
    public String displayPCRPage(@RequestParam("userID") String userID, Model theModel) {
    	System.out.println("hey");
        theModel.addAttribute("PCRs", covidInfo.listUserPCRs(userID));
        UserProfile user = userProfileRepository.findById(userID).get();
        theModel.addAttribute("user", user);
        String access = covidInfo.findAccessStatus(userID);
  	  	theModel.addAttribute("access", access);
        return "PCRTracker";
    }

    @GetMapping("/addPCR")
    public String displayAddPCRPage(@RequestParam("userID")String userID, Model theModel) {
        PCR newPCR = new PCR();
        theModel.addAttribute("newPCR", newPCR);
        UserProfile user = userProfileRepository.findById(userID).get();
        theModel.addAttribute("user", user);
        theModel.addAttribute("userID", userID);
        return "createPCR";
    }

    @GetMapping("/displayVaccTracker")
    public String displayVaccTracker(@RequestParam("userID") String userID, Model theModel) {
        theModel.addAttribute("Vaccines", covidInfo.getVaccineHistory(userID));
        UserProfile user = userProfileRepository.findById(userID).get();
        theModel.addAttribute("user", user);
        String access = covidInfo.findAccessStatus(userID);
  	  	theModel.addAttribute("access", access);
        return "VaccineTracker";
    }
}
