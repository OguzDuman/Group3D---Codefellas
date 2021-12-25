package com.example.pandemikent.Controller;

import java.util.List;

import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.UserProfileRepository;
import com.example.pandemikent.Service.UserProfileAccessService;
import com.example.pandemikent.Service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    UserProfileAccessService userProfileAccessService;
    @Autowired
    UserProfileRepository userProfileRepository;

    // @GetMapping("/login")
    // public @ResponseBody UserProfile login(@RequestParam String name, @RequestParam String password) {
    //     return userProfileAccessService.getUser(name);
    // }

    @GetMapping("/displayProfile")
    public @ResponseBody UserProfile displayUserProfile() {
        String name = userProfileAccessService.getCurrentUser();
        return userProfileService.displayUserInfo(name);
        // return userProfileService.displayUserInfo(name);
    }

    @PostMapping("/createProfile")
    public @ResponseBody String addUserProfile(@RequestParam int id,
                                                 @RequestParam String email) {
        String name = userProfileAccessService.getCurrentUser();
        if (userProfileService.addUserProfile(new UserProfile(name, id, email, true))) 

            return "Saved";
        else 
            return "Failed to save!";
    }

    @GetMapping("/")
    public String home(Model theModel) {
    	String name = userProfileAccessService.getCurrentUser();
    	UserProfile user = userProfileRepository.findById(name).get();
  	  	theModel.addAttribute("user", user);
        return "mainPage";
    }

    @GetMapping("/closeContacts")
    public @ResponseBody List<String> getCloseContacts() {
        String name = userProfileAccessService.getCurrentUser();
        return userProfileService.getCloseContacts(name);
    }

    @PostMapping("/addCloseContacts")
    public @ResponseBody List<String> addCloseContacts(@RequestParam String contact) {
        String name = userProfileAccessService.getCurrentUser();
        return userProfileService.addCloseContacts(name, contact);
    }
}
