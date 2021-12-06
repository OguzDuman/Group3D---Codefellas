package com.example.pandemikent.Repo;

import com.example.pandemikent.Model.Section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{
}
