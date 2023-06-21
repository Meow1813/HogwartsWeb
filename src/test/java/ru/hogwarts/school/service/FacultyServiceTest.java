package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {
    FacultyService out;
    @BeforeEach
    void setup(){
        out = new FacultyService();
        out.createFaculty(new Faculty("first","red"));
        out.createFaculty(new Faculty("second","red"));
        out.createFaculty(new Faculty("third","blue"));
    }

    @Test
    void createFaculty() {
        Faculty newFaculty = new Faculty("new","yellow");
        out.createFaculty(newFaculty);
        assertEquals(newFaculty,out.createFaculty(newFaculty));
    }

    @Test
    void findFacultyTrue() {
        assertEquals(new Faculty(2L,"second","red"),out.findFaculty(2));
    }
    @Test
    void findFacultyFalse() {
        assertNull(out.findFaculty(5));
    }

    @Test
    void editFacultyTrue() {
        Faculty newFaculty = new Faculty(2L,"red faculty","red");
        assertEquals(newFaculty, out.editFaculty(newFaculty));
        assertEquals(newFaculty, out.findFaculty(2));
    }
    @Test
    void editFacultyFalse() {
        assertNull(out.editFaculty(new Faculty(7L,"second","red")));
    }

    @Test
    void deleteFacultyTrue() {
        assertEquals(new Faculty(2L,"second","red"),out.deleteFaculty(2));
        assertNull(out.findFaculty(2));
    }
    @Test
    void deleteFacultyFalse() {
        assertNull(out.deleteFaculty(5));
    }


    @Test
    void getFacultiesByColorTrue() {
        List<Faculty> list = new ArrayList<>(List.of(new Faculty(1L,"first","red"),
                                                     new Faculty(2L,"second","red")));
        assertEquals(list,out.getFacultiesByColor("red"));
    }
    @Test
    void getFacultiesByColorFalse() {
        List<Faculty> list = new ArrayList<>();
        assertEquals(list,out.getFacultiesByColor("green"));
    }
}