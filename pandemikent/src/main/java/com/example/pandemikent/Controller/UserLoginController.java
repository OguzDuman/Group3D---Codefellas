package com.example.pandemikent.Controller;

import java.util.Optional;

import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.UserLoginRepository;
import com.example.pandemikent.Service.UserProfileService;
import com.example.pandemikent.Service.UserProfileAccessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserLoginController {
    
  @Autowired
  private UserLoginRepository userRepository;
  @Autowired
  private UserProfileService userProfileService;
  @Autowired
  private UserProfileAccessService  accessService;

  @GetMapping(path="/login")
  public String login(){
    return "login";
  }

  @GetMapping(path="/createAccount") 
  public String createAccount () {    
      return "signup";
  }

  @PostMapping(path="/submit") 
  public String addNewUser (@RequestParam String name, @RequestParam String password,
                                          @RequestParam String role, @RequestParam String number, @RequestParam String email) {    
    Optional<UserLogin> s = userRepository.findById(name);
    System.out.print(s);
    if (s == null){
      return "Error";
    }
    
    if (role != null && ( role.equals("INSTRUCTOR") || role.equals("STUDENT") ) ) {
      userRepository.save( new UserLogin(name, password, role));
      userProfileService.addUserProfile(new UserProfile(name, Integer.parseInt(number), email, true));
    }
    else 
      return "Error";

    return "login";
  }

  @GetMapping(path="/all")
  public @ResponseBody String getAllUsers() {
    return accessService.getCurrentUser();
  }
}