package com.example.test.web.rest;


import com.example.test.model.StudyProgram;
import com.example.test.service.impl.StudyProgramImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/study_programs", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class StudyProgramResource {

    private final StudyProgramImpl studyProgram;

    @Autowired
    public StudyProgramResource(StudyProgramImpl studyProgram) {
        this.studyProgram = studyProgram;
    }

    @GetMapping
    public List<StudyProgram> getAllStudyPrograms()
    {
        return studyProgram.getAllStudyPrograms();
    }

    @PostMapping
    public StudyProgram addNewStudyProgram(StudyProgram entity)
    {
        return studyProgram.addNew(entity);
    }

    @DeleteMapping("/{id}")
    public StudyProgram deleteStudyProgram(@PathVariable(value="id")Long id)
    {
        return studyProgram.delete(id);
    }
}
