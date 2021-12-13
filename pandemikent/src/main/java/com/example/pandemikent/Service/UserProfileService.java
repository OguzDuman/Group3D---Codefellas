package com.example.pandemikent.Service;

import com.example.pandemikent.Model.Instructor;
import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.InstructorRepository;
import com.example.pandemikent.Repo.StudentRepository;
import com.example.pandemikent.Repo.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InstructorRepository instructorRepository;

    public UserProfile displayUserInfo(String id){   
        // find in the profile
        UserProfile profile = userProfileRepository.findById(id).get();

        return profile;
    }

    // how can anything be updated without direct access to the database  _____+++++++
    public UserProfile updateUserInfo(String id, UserProfile user) {
        // find in the profile
        UserProfile profile = userProfileRepository.findById(id).get();

        userProfileRepository.save(user);
        
        Student student = studentRepository.findById(id).get();
        if (student == null) {
            Instructor instructor = instructorRepository.findById(id).get();
            instructor.setEmail(user.getEmail());
            instructor.setId(user.getId());
        }
        else {
            student.setEmail(user.getEmail());
            student.setId(user.getId());
        }
        // old version returned 
        return profile;
    }

}
