package com.springreact.studentdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.studentdashboard.model.Student;
import com.springreact.studentdashboard.service.StudentService;

@CrossOrigin("http://localhost:3000") //allowing client application to consume the backed
@RestController
@RequestMapping("/students")
public class MyController {

    @Autowired
    private StudentService studentService;


    //endpoints

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudent() {
        return new ResponseEntity<>(studentService.getStudent(), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        // System.out.println("tension nhi lena ka
        // "+studentService.addStudent(student));
        return studentService.addStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return studentService.updateStudent(student, id);
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // @DeleteMapping("/deleteStudent/{id}")
    // public void deleteStudent(@PathVariable Long id)
    // {
    // studentService.deleteStudent(id);
    // }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
