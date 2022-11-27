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
    public String home(){
        return "home";
    }

    @GetMapping("/students")
    public String viewAllStudents(Model model){
        List<Student> stu = studentService.displayAllStudents();
//        model.addAttribute("students",studentService.displayAllStudents());
        model.addAttribute("students",stu);
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("students",student);
        return "registerStudent";
    }

    @PostMapping("/add-students")
    public String addStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }




}
