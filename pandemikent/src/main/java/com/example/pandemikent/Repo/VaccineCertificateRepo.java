package com.example.pandemikent.Repo;

import org.springframework.stereotype.Repository;

import com.example.pandemikent.Model.VaccineCertificate;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VaccineCertificateRepo extends JpaRepository<VaccineCertificate, String>{
    
}
