package com.example.webbasedspringapi.Service;

import com.example.webbasedspringapi.Entities.Student;
import com.example.webbasedspringapi.Repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private studentRepository studentrepository;


    public List<Student> getAllstudents(){
        return studentrepository.findAll();
    }
    public void saveStudent(Student student){
        studentrepository.save(student);
    }
    public void deleteStudent(int id){
        studentrepository.deleteById(id);
    }
    public Student editStudent(int id){
        return studentrepository.findById(id).orElse(null);
    }

}
