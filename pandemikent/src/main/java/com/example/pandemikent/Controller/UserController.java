package com.example.pandemikent.Controller;

import com.example.pandemikent.Model.User;
import com.example.pandemikent.Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/showStudents")
public class UserController {
    
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam int id, @RequestParam String password) {

    User n = new User();
    n.setUsername(name);
    n.setId(id);
    n.setPassword(password);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}