package ru.hogwarts.school.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {
    @InjectMocks
    FacultyService out;
    @Mock
    private FacultyRepository repository;

    @Test
    void createFaculty() {
        Faculty newFaculty = new Faculty(2L, "new", "yellow");
        when(repository.save(newFaculty)).thenReturn(newFaculty);
        assertEquals(newFaculty, out.createFaculty(newFaculty));
    }

    @Test
    void findFacultyTrue() {
        Faculty newFaculty = new Faculty(2L, "second", "red");
        when(repository.findById(2L)).thenReturn(Optional.of(newFaculty));
        assertEquals(newFaculty, out.findFaculty(2));
    }

    @Test
    void findFacultyFalse() {
        when(repository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> out.findFaculty(2));
    }

    @Test
    void editFaculty() {
        Faculty newFaculty = new Faculty(2L, "new", "yellow");
        when(repository.save(newFaculty)).thenReturn(newFaculty);
        assertEquals(newFaculty, out.editFaculty(newFaculty));
    }

    @Test
    void getFacultiesByColorTrue() {
        List<Faculty> list = new ArrayList<>(List.of(new Faculty(1L, "first", "red"),
                new Faculty(2L, "second", "red")));
        when(repository.findByColor("red")).thenReturn(list);
        assertEquals(list, out.getFacultiesByColor("red"));
    }

    @Test
    void getFacultiesByColorFalse() {
        List<Faculty> list = new ArrayList<>();
        when(repository.findByColor("green")).thenReturn(list);
        assertEquals(list, out.getFacultiesByColor("green"));
    }

}