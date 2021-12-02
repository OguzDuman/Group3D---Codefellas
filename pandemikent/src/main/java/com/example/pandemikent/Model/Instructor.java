package com.example.pandemikent.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends UserProfile{
    // The identifies in the super class will automatically be used 
    // as an identifier here
}
