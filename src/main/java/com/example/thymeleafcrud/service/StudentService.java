package com.example.thymeleafcrud.service;

import com.example.thymeleafcrud.entity.Student;
import com.example.thymeleafcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> displayAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student editStudent(int id) {
        Student existingStudent = studentRepository.findById((long) id).orElse(null);
        return existingStudent;
    }

    public Student updateStudent(int id, Student student) {
        Student existingStudent = studentRepository.findById((long) id).orElse(null);
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentFaculty(student.getStudentFaculty());
        existingStudent.setStudentEmail(student.getStudentEmail());
        studentRepository.save(existingStudent);
        return existingStudent;
    }
}
