package com.example.pandemikent.Repo;

// imports
import com.example.pandemikent.Model.Attendance;
import org.springframework.data.repository.CrudRepository;


public interface AttendanceRepository extends CrudRepository<Attendance, String> {
}