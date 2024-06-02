package com.saurabhbarmase.studentCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.saurabhbarmase.studentCRUD.exception.ResourceNotFoundException;
import com.saurabhbarmase.studentCRUD.model.Student;
import com.saurabhbarmase.studentCRUD.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new ResourceNotFoundException("Student with ID " + id + " not found");
        }
        return student;
    }

    public Student createOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}
