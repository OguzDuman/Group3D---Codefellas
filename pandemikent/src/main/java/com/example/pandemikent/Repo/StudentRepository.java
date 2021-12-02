package com.example.pandemikent.Repo;

import com.example.pandemikent.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
    
}
