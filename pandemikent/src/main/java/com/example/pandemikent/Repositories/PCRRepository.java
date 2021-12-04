package com.example.pandemikent.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pandemikent.Entities.PCR;

@Repository
public interface PCRRepository extends JpaRepository<PCR, Long> {
}
