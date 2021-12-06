package com.example.pandemikent.Repo;

import com.example.pandemikent.Model.HESCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HESCodeRepository extends JpaRepository<HESCode, Long> {
}
