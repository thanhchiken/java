package com.k21cnt.ntt.lesson09.service;


import com.k21cnt.ntt.lesson09.entity.Student;
import com.k21cnt.ntt.lesson09.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Long id, Student student) {
        return studentRepository.findById(id).map(stud ->{
            stud.setName(student.getName());
            stud.setAge(student.getAge());
            stud.setEmail(student.getEmail());
            return studentRepository.save(stud);
        })
                .orElse(null);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
