package com.example.pandemikent.Service;

import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.InstructorRepository;
import com.example.pandemikent.Repo.StudentRepository;
import com.example.pandemikent.Repo.UserLoginRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileAccessService {
    @Autowired
    private  UserLoginRepository userLoginRepository;
    @Autowired
    private  StudentRepository studentRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    
    public UserProfile login(String id, String password) {
        UserLogin user = userLoginRepository.findById(id).get();
        
        // check password
        if (user.getPassword() == password) {
            // find in Student
            UserProfile profile = studentRepository.findById(id).get();

            // if the profile is not of a student
            if (profile == null) {
                profile = instructorRepository.findById(id).get();
            }
            return profile;
        }

        return null;
    }
}
