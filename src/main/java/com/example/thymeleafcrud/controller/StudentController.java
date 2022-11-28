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

    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.editStudent(id));
        return "updateForm";
    }

    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student, Model model){
        model.addAttribute("student",studentService.updateStudent(id,student));
        return "redirect:/students";
    }

    // links are get method by default so use gert mapping instead of delete mapping
    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @PostMapping("/search-student")
    public String searchStudent(@RequestParam(value="studentName", required=true) String studentName,Model model){
        List<Student> foundStudents = studentService.searchStudent(studentName);
        model.addAttribute("student",foundStudents);
        return "searchResult";
    }


}
