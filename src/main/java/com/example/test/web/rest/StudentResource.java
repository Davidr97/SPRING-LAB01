package com.example.test.web.rest;


import com.example.test.model.Student;
import com.example.test.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class StudentResource {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentResource(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{index}")
    public Student getStudentByIndex(@PathVariable(value="index")Long index)
    {
        return studentService.getStudentByIndex(index);
    }

    @GetMapping("by_study_program/{id}")
    public List<Student> getAllStudentsIn(@PathVariable(value="id")Long id)
    {
        return studentService.getAllStudentsInStudyProgram(id);
    }

    @DeleteMapping("/{index}")
    public Student deleteStudent(@PathVariable(value="index")Long index)
    {
        return studentService.delete(index);
    }

    @PostMapping
    public Student addNewStudent(@RequestParam(value="name")String name,@RequestParam(value="lastName")String lastName,
                @RequestParam(value="index")String index,@RequestParam(value="studyProgramName")String studyProgramName)
    {
        return studentService.addNew(index, name, lastName, studyProgramName);
    }

    @PatchMapping("/{index}")
    public Student updateStudent(@PathVariable(value="index")Long index,@RequestParam(value="name")String name,
                                 @RequestParam(value="lastName")String lastName,@RequestParam(value="studyProgramName")String studyProgramName)
    {
        return studentService.update(index, name, lastName, studyProgramName);
    }


}
