package com.example.pandemikent.Controller;

import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Repo.UserLoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/login")
public class UserLoginController {
    
  @Autowired
  private UserLoginRepository userRepository;

  @GetMapping(path="/submit") 
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String password) {    
    UserLogin temp = userRepository.findById(name).get();
    
    if (temp == null || temp.getPassword() != password)
      return "Access Denied";
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<UserLogin> getAllUsers() {
    return userRepository.findAll();
  }
}