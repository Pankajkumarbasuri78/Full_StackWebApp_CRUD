package com.springreact.studentdashboard.service;

import java.util.List;

import com.springreact.studentdashboard.model.Student;

// import com.springreact.studentdashboard.model.Student;

public interface StudentService {

    // addStudent
    Student addStudent(Student student);

    // getStudent
    List<Student> getStudent();

    // updateStudent
    Student updateStudent(Student student, Long id);

    Student getStudentById(Long id);
    // void deleteStudent(Long id);

    String deleteStudent(Long id);

}
