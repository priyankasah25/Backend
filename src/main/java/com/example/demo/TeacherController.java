package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("/teachers/{teacherId}/students")
    public Student addStudentToTeacher(@PathVariable Long teacherId, @Valid @RequestBody Student student) {
        return teacherService.addStudentToTeacher(teacherId, student);
    }

    @GetMapping("/teachers/{teacherId}/students")
    public List<Student> getStudentsOfTeacher(@PathVariable Long teacherId) {
        return teacherService.getStudentsOfTeacher(teacherId);
    }
}