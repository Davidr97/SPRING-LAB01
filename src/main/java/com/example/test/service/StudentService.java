package com.example.test.service;

import com.example.test.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentByIndex(Long index);

    List<Student> getAllStudentsInStudyProgram(Long id);

    Student addNew(String index, String name, String lastName, String studyProgramName);

    Student update(Long index, String name, String lastName, String studyProgramName);

    Student delete(Long index);

}
