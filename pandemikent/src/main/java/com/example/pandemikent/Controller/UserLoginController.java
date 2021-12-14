package com.example.pandemikent.Controller;

import java.util.Optional;

import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Repo.UserLoginRepository;

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

  @PostMapping(path="/submit") 
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String password,
                                          @RequestParam String role) {    
    Optional<UserLogin> s = userRepository.findById(name);
    System.out.print(s);
    if (s == null){
      return "Access Denied";
    }
    
    if (role != null && ( role.equals("INSTRUCTOR") || role.equals("STUDENT") ) )
      userRepository.save( new UserLogin(name, password, role));
    else 
      return "Failed to save";

    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<UserLogin> getAllUsers() {
    return userRepository.findAll();
  }
}