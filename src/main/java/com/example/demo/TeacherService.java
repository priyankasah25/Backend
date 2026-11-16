package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No teacher with that id"));
    }

    public Student addStudentToTeacher(Long teacherId, Student student) {
        Teacher teacher = getTeacherById(teacherId);
        student.setTeacher(teacher);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsOfTeacher(Long teacherId) {
        getTeacherById(teacherId);
        return studentRepository.findByTeacherId(teacherId);
        
    }
}