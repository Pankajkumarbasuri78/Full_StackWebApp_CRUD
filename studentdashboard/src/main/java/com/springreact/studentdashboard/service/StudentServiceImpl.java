package com.springreact.studentdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.studentdashboard.exception.StudentAlreadyExistsException;
import com.springreact.studentdashboard.exception.StudentNotFoundException;
import com.springreact.studentdashboard.model.Student;
import com.springreact.studentdashboard.repo.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    // method implementation

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudent(Student student) {

        if(studentAlreadyExists(student.getEmail()))
        {
            throw new StudentAlreadyExistsException(student.getEmail()+" already exists");
        }
        return studentRepo.save(student);
    }


    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepo.findById(id).map(st->{
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepo.save(st);
        }).orElseThrow(()->new StudentNotFoundException("Sorry,this could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                          .orElseThrow(()->new StudentNotFoundException("no such Student found with this id "+id));
    }

    
    @Override
    public String deleteStudent(Long id) {

        if(!studentRepo.existsById(id))
        {
            throw new StudentNotFoundException("Can't Remove as Student not found with id "+id);
        }
        studentRepo.deleteById(id);
        return "deleted";
    }


    //internal methods

    private boolean studentAlreadyExists(String email) {
        return studentRepo.findByEmail(email).isPresent();
    }

}
