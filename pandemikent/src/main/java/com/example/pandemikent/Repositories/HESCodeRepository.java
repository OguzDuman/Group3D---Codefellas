package com.example.pandemikent.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pandemikent.Entities.HESCode;

@Repository
public interface HESCodeRepository extends JpaRepository<HESCode, Long> {
}
