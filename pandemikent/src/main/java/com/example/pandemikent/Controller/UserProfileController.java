package com.example.pandemikent.Controller;

import com.example.pandemikent.Service.UserProfileAccessService;
import com.example.pandemikent.Service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    UserProfileAccessService userProfileAccessService;

    // @GetMapping("/login")
    // public @ResponseBody UserProfile login(@RequestParam String name, @RequestParam String password) {
    //     return userProfileAccessService.getUser(name);
    // }

    // @GetMapping("/displayProfile")
    // public @ResponseBody UserProfile displayUserProfile(@RequestParam String name) {
    //     return userProfileService.displayUserInfo(name);
    // }

    @GetMapping("/")
    public @ResponseBody String displayUserProfile() {
        return "Hello!";
    }
}
