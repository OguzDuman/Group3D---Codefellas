package com.example.pandemikent.Repo;

// imports
import com.example.pandemikent.Model.Class;

// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClassRepository extends CrudRepository<Class, String> {

    // @Modifying
    // @Query("update Class u set u.users = ?1, u.lastname = ?2 where u.id = ?3")
    // void setUserInfoById(String firstname, String lastname, Integer userId);
}