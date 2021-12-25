package com.example.pandemikent.Repo;

import com.example.pandemikent.Model.PCR;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PCRRepository extends JpaRepository<PCR, Long> {
	@Query(value = "SELECT * FROM pandemikent.PCR WHERE patient_id = :id", nativeQuery = true)
	public List<PCR> getPCRByPatientId(String id);
}
