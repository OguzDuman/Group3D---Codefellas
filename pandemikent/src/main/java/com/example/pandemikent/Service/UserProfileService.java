package com.example.pandemikent.Service;

import java.util.List;
import java.util.Optional;

import com.example.pandemikent.Model.Instructor;
import com.example.pandemikent.Model.Student;
import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.InstructorRepository;
import com.example.pandemikent.Repo.StudentRepository;
import com.example.pandemikent.Repo.UserLoginRepository;
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
    @Autowired
    private UserProfileAccessService accessService;
    @Autowired
    private UserLoginRepository userLoginRepository;

    public UserProfile displayUserInfo(String id){   
        // find in the profile
        // UserProfile profile = userProfileRepository.findById(id).get();
        // find if user exists
        UserProfile profile;
        if (accessService.getUser(id) == null) 
            return null;
        else {
            Optional<Student> tempStudent;
            Optional<Instructor> tempInst;

            // find in Student table
            tempStudent = studentRepository.findById(id);

            // if not present, find in Instructor table
            if (tempStudent.isEmpty()){
                tempInst = instructorRepository.findById(id);
                if (tempInst.isEmpty()) {
                    System.out.println("System error! Can't find user");
                    return null;
                } else {
                    profile = tempInst.get();
                }
            } else {
                System.out.println(tempStudent + "-------------------------");
                profile = tempStudent.get();
            }
        } 

        return profile;
    }

    public boolean addUserProfile(UserProfile user) {

        Optional<UserLogin> temp = userLoginRepository.findById(user.getUsername());
        UserLogin u;

        if (temp != null)
            u = temp.get();
        else 
            return false;

        if (u.getRole().contains("STUDENT")) {
            studentRepository.save(new Student(user.getUsername(), user.getId(), user.getEmail()));
        }
        else if (u.getRole().contains("INSTRUCTOR")) {
            instructorRepository.save(new Instructor(user.getUsername(), user.getId(), user.getEmail()));
        }
        else {
            return false;
        }

        return true;
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

    public List<String> getCloseContacts(String name) {
        Optional<UserLogin> temp = userLoginRepository.findById(name);

        if (temp.isEmpty())
            return null;

        if (temp.get().getRole().contains("STUDENT")) {
            Optional<Student> student = studentRepository.findById(name);
            Student s = student.get();
            return s.getCloseContacts();
        } else {
            return null;
        }

        
    }

    public List<String> addCloseContacts(String name, String contact) {
        Optional<UserLogin> temp = userLoginRepository.findById(name);

        if (temp.isEmpty())
            return null;

        if (temp.get().getRole().contains("STUDENT")) {
            Optional<Student> student = studentRepository.findById(name);
            Student s = student.get();
            List<String> list = s.getCloseContacts();
            if (!list.contains(contact)) {
                list.add(contact);
                studentRepository.save(s);
            }
            return list;
        } else {
            return null;
        }

        
    }
}
