package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentService out;
    @BeforeEach
    void setup(){
        out = new StudentService();
        out.createStudent(new Student("first",20));
        out.createStudent(new Student("second",20));
        out.createStudent(new Student("third",19));
    }

    @Test
    void createStudent() {
        Student newStudent = new Student("new",20);
        out.createStudent(newStudent);
        assertEquals(newStudent,out.createStudent(newStudent));
    }

    @Test
    void findStudentTrue() {
        assertEquals(new Student(2L,"second",20),out.findStudent(2));
    }
    @Test
    void findStudentFalse() {
        assertNull(out.findStudent(5));
    }

    @Test
    void editStudentTrue() {
        Student newStudent = new Student(2L,"2nd",20);
        assertEquals(newStudent, out.editStudent(newStudent));
        assertEquals(newStudent, out.findStudent(2));
    }
    @Test
    void editStudentFalse() {
        assertNull(out.editStudent(new Student(7L,"second",20)));
    }

    @Test
    void deleteStudentTrue() {
        assertEquals(new Student(2L,"second",20),out.deleteStudent(2));
        assertNull(out.findStudent(2));
    }
    @Test
    void deleteStudentFalse() {
        assertNull(out.deleteStudent(5));
    }


    @Test
    void getStudentsByAgeTrue() {
        List<Student> list = new ArrayList<>(List.of(new Student(1L,"first",20),
                new Student(2L,"second",20)));
        assertEquals(list,out.getStudentsByAge(20));
    }
    @Test
    void getStudentsByColorFalse() {
        List<Student> list = new ArrayList<>();
        assertEquals(list,out.getStudentsByAge(21));
    }
}