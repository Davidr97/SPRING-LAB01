package com.example.test.service.impl;

import com.example.test.model.Student;
import com.example.test.model.StudyProgram;
import com.example.test.model.exception.IndexBadlyFormattedException;
import com.example.test.model.exception.StudentExistsException;
import com.example.test.model.exception.StudentNotFoundException;
import com.example.test.model.exception.StudyProgramNotFoundException;
import com.example.test.persistence.StudentRepository;
import com.example.test.persistence.StudyProgramRepository;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudyProgramRepository studyProgramRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository) {
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public Student getStudentByIndex(Long index) {
        return studentRepository.findById(index).orElse(null);
    }

    @Override
    public List<Student> getAllStudentsInStudyProgram(Long id) {
        return studentRepository.findAllStudentsInStudyProgram(id);
    }

    @Override
    public Student addNew(String index, String name, String lastName, String studyProgramName) throws
                    IndexBadlyFormattedException, StudyProgramNotFoundException, StudentExistsException
    {
        Long idx = Long.parseLong(index);
        if(studentRepository.existsById(idx)){
            throw new StudentExistsException(idx);
        }
        if(!index.matches("\\d{6}")){
            throw new IndexBadlyFormattedException(index);
        }
        StudyProgram studyProgram = studyProgramRepository.findByName(studyProgramName).orElseThrow(() -> new StudyProgramNotFoundException(studyProgramName));
        return studentRepository.save(new Student(name, lastName, studyProgram));
    }

    @Override
    public Student update(Long index, String name, String lastName, String studyProgramName) throws StudentNotFoundException,
                                                                                StudyProgramNotFoundException
    {
        if(!studentRepository.existsById(index)){
            throw new StudentNotFoundException(index);
        }
        if(!studyProgramRepository.existsByName(studyProgramName)){
            throw new StudyProgramNotFoundException(studyProgramName);
        }
        Student student = studentRepository.findById(index).orElse(null);
        studyProgramRepository.delete(student.getStudyProgram());
        StudyProgram newStudyProgram = new StudyProgram(studyProgramName);
        studyProgramRepository.save(newStudyProgram);
        Student newStudent = new Student(name, lastName, newStudyProgram);
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public Student delete(Long index) throws StudentNotFoundException {
        Student student = studentRepository.findById(index).orElseThrow(() -> new StudentNotFoundException(index));
        studentRepository.delete(student);
        return student;
    }
}
