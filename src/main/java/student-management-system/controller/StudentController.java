package com.example.student_management_system.controller; // 💡 Ensure this matches your folder structure (e.g., uses underscores if your path does)

import com.example.student_management_system.model.Student; // 🚨 CORRECTED IMPORT
import com.example.student_management_system.service.StudentService; // 🚨 CORRECTED IMPORT
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Must be final for Constructor Injection
    private final StudentService studentService;

    // ✅ Spring automatically injects the StudentService instance
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "✅ Student added successfully!";
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}