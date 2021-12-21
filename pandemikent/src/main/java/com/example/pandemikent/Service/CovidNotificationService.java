package com.example.pandemikent.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

import com.example.pandemikent.Model.*;
import com.example.pandemikent.Model.Class;
import com.example.pandemikent.Repo.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Query;

@Service
public class CovidNotificationService {
    @Autowired
    private StudentRepository studentRepository;

    public String createWeeklyReport() {
        int numberOfInfectedStudents = 0;
        for (Student s : studentRepository.findAll()) {
            if (s.getIsQuarantined()) {
                numberOfInfectedStudents++;
            }
        }
        String weeklyReport = "There are " + numberOfInfectedStudents + " infected students in the university.";
        return weeklyReport;
    }

    public List<User> getRiskyStudents() { // Will be completed after I get the Safety Rating Risk algorithm!
        return null;
    }

    public Boolean notifyCovidSituation(String userID) {
        Optional<Student> s = studentRepository.findById(userID);
        for (int i = 0; i < s.get().closeContacts.size(); i++) { // We iterate through all the close contacts of the student.
            Optional<Student> closeContact = studentRepository.findById(s.get().closeContacts.get(i));
            if (closeContact.get().getIsQuarantined()) {
                //System.out.println("You are at risk!"); We have to somehow notify the student!
                return true;
            }
        }
        return false;
    }

    public String notifySafetyRanking(String userID) { // What is the algorithm here?
        return null;
    }
}
