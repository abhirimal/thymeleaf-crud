package com.example.thymeleafcrud;

import com.example.thymeleafcrud.entity.Student;
import com.example.thymeleafcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafCrudApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafCrudApplication.class, args);
    }

}
