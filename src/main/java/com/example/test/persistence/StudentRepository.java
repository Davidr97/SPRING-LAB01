package com.example.test.persistence;

import com.example.test.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends StudentBaseRepository<Student, Long> {

    @Query("select s.id, s.name, s.lastName from Student s")
    List<Student> findAllStudents();

    @Query("select s from Student s where s.studyProgram.id=?1")
    List<Student> findAllStudentsInStudyProgram(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Student s SET s.name = ?2, s.lastName = ?3, s.studyProgram.name = ?4 where s.id = ?1")
    void updateStudent(Long index, String name, String lastName, String studyProgramName);
}
