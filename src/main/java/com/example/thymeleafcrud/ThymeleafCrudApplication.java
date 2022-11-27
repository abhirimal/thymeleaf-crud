package com.example.thymeleafcrud;

import com.example.thymeleafcrud.entity.Student;
import com.example.thymeleafcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafCrudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafCrudApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("Abhiyan","Software","abhiyan@gmail.com");
        studentRepository.save(student1);

        Student student2 = new Student("Tracy","Software","tracy@gmail.com");
        studentRepository.save(student2);
    }
}
