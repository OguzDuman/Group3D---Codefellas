package com.example.pandemikent.Security;

import com.example.pandemikent.Model.UserLogin;
import com.example.pandemikent.Repo.UserLoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PandemikentUserDetailsService implements UserDetailsService{
    @Autowired
    UserLoginRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = repo.findById(username).get();
        if (user == null) throw new UsernameNotFoundException("User was not found in the database");

        return user;
    }
    
}
