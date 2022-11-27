package com.example.thymeleafcrud.controller;

import com.example.thymeleafcrud.entity.Student;
import com.example.thymeleafcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String viewAllStudents(Model model){
        List<Student> stu = studentService.displayAllStudents();
//        model.addAttribute("students",studentService.displayAllStudents());
        model.addAttribute("students",stu);
        return "students";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student, Model model){
        studentService.saveStudent(student);
        return "students";
    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "students";
    }




}