package com.example.pandemikent.Controller;

import com.example.pandemikent.Model.Exam;
import com.example.pandemikent.Repo.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/showExams")
public class ExamController {
    
  @Autowired 
  private ExamRepository examRepository;

  @PostMapping(path="/addExam")
  public @ResponseBody String addNewExam (@RequestParam String reasons, @RequestParam String date) {
    
    Exam n = new Exam();
    examRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/allExams")
  public @ResponseBody Iterable<Exam> getAllExam() {

    return examRepository.findAll();
  }
}