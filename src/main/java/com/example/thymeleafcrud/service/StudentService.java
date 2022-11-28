package com.example.thymeleafcrud.service;

import com.example.thymeleafcrud.entity.Student;
import com.example.thymeleafcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> displayAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        Student newStudent = new Student();
        String encryptedPassword = DigestUtils.md5DigestAsHex(student.getStudentPassword().getBytes());
        newStudent.setStudentName(student.getStudentName());
        newStudent.setStudentFaculty(student.getStudentFaculty());
        newStudent.setStudentEmail(student.getStudentEmail());
        newStudent.setStudentPassword(encryptedPassword);
        studentRepository.save(newStudent);
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

    public List<Student> searchStudent(String studentName) {
        return  studentRepository.findByStudentName(studentName);
    }
}
