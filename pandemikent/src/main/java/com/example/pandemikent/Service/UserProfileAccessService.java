package com.example.pandemikent.Service;

import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.UserLoginRepository;
import com.example.pandemikent.Repo.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileAccessService{
    @Autowired
    private  UserProfileRepository userProfileRepository;
    
    public UserProfile getUser(String id) {
        // UserLogin user = userLoginRepository.findById(id).get();
        UserProfile user = userProfileRepository.findById(id).get();
        // // check password
        // if (user.getPassword() == password) {
        //     // find in Student
        //     UserProfile profile = userProfileRepository.findById(id).get();

        //     return profile;
        // }

        return user;
    }
    
}
