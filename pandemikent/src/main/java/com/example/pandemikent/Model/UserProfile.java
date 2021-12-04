package com.example.pandemikent.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type", 
 discriminatorType = DiscriminatorType.STRING)
@Table(name="UserProfile")
public class UserProfile {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="id")
    private int id;
    @Column(name="email")
    private String email;

    // Constructors
    public UserProfile(String username, int id, String email) {
        this.username = username;
        this.id = id;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfile() {
        this.username = null;
        this.id = -1;
        this.email = null;
    }

    // Functions

}
