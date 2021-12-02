package com.example.pandemikent.Controller;

import java.util.ArrayList;
import java.util.Optional;

import com.example.pandemikent.Model.Class;
import com.example.pandemikent.Repo.ClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/showClasses")
public class ClassController {
    
  @Autowired
  private ClassRepository classRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewClass (@RequestParam String name, @RequestParam String instructor) {

    Class n = new Class(name, instructor, new ArrayList<Integer>());
    classRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Class> getAllClasses() {
    return classRepository.findAll();
  }

  // @PostMapping(path="/delete")
  // public @ResponseBody Optional<Class> deleteClass(@RequestParam String name) {
  //   Optional<Class> temp = classRepository.findById(name);
  //   classRepository.deleteById(name);
  //   return temp;
  // }

  @PutMapping(path="/addMember")
  public @ResponseBody Class addClassMember(@RequestParam String name,
                                             @RequestParam int id) {
    Class temp = classRepository.findById(name).get();
    System.out.println(temp);
    temp.addUser(id);
    System.out.println(temp);
    classRepository.save(temp);
    
    return temp;
  }
}