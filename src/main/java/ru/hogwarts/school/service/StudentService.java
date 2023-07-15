package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student: {}", student);
        return studentRepository.save(student);
    }


    public Student findStudent(long id) {
        logger.info("Was invoked method to find student by id: {}", id);
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for edit student");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Was invoked method for delete student by id: {}", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsByAge(int age) {
        logger.info("Was invoked method to find student by age {}", age);
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getStudentsByAgeBetween(int min, int max) {
        logger.info("Was invoked method for find student between {} and {} age", min, max);
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getStudentFaculty(long id) {
        logger.info("Was invoked method to get info about student`s faculty");
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get().getFaculty();
        }
        logger.warn("Current student doesnt have a faculty");
        return null;
    }

    public int getStudentCount() {
        logger.info("Was invoked method to get student count");
        return studentRepository.getStudentCount();
    }

    public int getStudentAvgAge() {
        logger.info("Was invoked method to get student avg age");
        return studentRepository.getStudentAvgAge();
    }

    public Collection<Student> getLast5Student() {
        logger.info("Was invoked method for get last 5 students");
        return studentRepository.getLast5Students();
    }
}
