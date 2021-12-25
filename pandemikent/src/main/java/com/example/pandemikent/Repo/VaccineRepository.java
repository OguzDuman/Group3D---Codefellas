package com.example.pandemikent.Repo;

import com.example.pandemikent.Model.PCR;
import com.example.pandemikent.Model.Vaccine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
	@Query(value = "SELECT * FROM pandemikent.Vaccine WHERE patient_id = :id", nativeQuery = true)
	public List<Vaccine> getVaccineByPatientId(String id);
}
