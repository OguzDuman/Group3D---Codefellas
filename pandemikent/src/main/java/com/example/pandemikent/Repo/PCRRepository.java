package com.example.pandemikent.Repo;

import com.example.pandemikent.Model.PCR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRRepository extends JpaRepository<PCR, Long> {
}
