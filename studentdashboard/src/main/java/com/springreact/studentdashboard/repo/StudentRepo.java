package com.springreact.studentdashboard.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springreact.studentdashboard.model.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{

    //custom finder methods
    Optional<Student> findByEmail(String email);
    
}
