package com.example.pandemikent.Repo;

// imports
import com.example.pandemikent.Model.Quarantine;
import org.springframework.data.repository.CrudRepository;


public interface QuarantineRepository extends CrudRepository<Quarantine, String> {
}