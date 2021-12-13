package com.example.pandemikent.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user_acc")
public class UserLogin implements UserDetails{
    @Id
    @Column(name="username")
    private String  username;
    @Column(name="password")
    private String  password;
    @ElementCollection
    @CollectionTable(name ="roles")
    private List<String> role = new ArrayList<>();

    // Constructors
    public UserLogin(int id, String username, String password) {
        this.username = username;
        this.password = password;
        role.add("USER");
        role.add("ADMIN");
    }

    public UserLogin() {
        this.username = null;
        this.password = null;
    }

    // Functions
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User [ password=" + password + ", username=" + username + "]";
    }

    public List<String> getRoles() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for(String r: role) 
            authorities.add(new SimpleGrantedAuthority("ROLE_" + r));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
