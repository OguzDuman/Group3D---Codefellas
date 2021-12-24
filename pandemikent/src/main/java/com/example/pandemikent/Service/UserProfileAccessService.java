package com.example.pandemikent.Service;

import java.util.Optional;

import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Model.UserProfile;
import com.example.pandemikent.Repo.UserLoginRepository;
import com.example.pandemikent.Repo.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileAccessService{
    @Autowired
    private  UserLoginRepository userLoginRepository;
    
    public UserLogin getUser(String id) {
        // UserLogin user = userLoginRepository.findById(id).get();
        Optional<UserLogin> temp = userLoginRepository.findById(id);
        UserLogin user = null;
        if (temp != null)
            user = temp.get();

        return user;
    }

    public String getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    
}
