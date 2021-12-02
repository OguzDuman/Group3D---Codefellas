package com.example.pandemikent.Repo;

// imports
import com.example.pandemikent.Model.UserLogin;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserLoginRepository extends CrudRepository<UserLogin, String> {
}