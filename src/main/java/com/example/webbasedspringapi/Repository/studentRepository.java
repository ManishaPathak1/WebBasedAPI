package com.example.webbasedspringapi.Repository;

import com.example.webbasedspringapi.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student,Integer> {
}
