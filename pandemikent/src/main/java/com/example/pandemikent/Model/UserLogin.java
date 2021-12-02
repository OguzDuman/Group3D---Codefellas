package com.example.pandemikent.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserLogin {
    @Id
    @Column(name="username")
    private String  username;
    @Column(name="password")
    private String  password;

    // Constructors
    public UserLogin(int id, String username, String password) {
        this.username = username;
        this.password = password;
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
}
