package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
       Student response = studentRepo.save(student);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/fetchall")
    public List<Student> getAllStudent(){
        List<Student> studentList =studentRepo.findAll();
        return studentList;
    }

    @GetMapping("/fetchbyId/{id}")
    public Student getStudent(@PathVariable Long id){
        Student student=studentRepo.findById(id).orElse(null);
        return student;
    }

    


}

