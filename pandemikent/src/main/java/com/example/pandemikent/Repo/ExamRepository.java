package com.example.pandemikent.Repo;

// imports
import com.example.pandemikent.Model.Exam;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ExamRepository extends CrudRepository<Exam, Integer> {

}