package com.example.test.service.impl;

import com.example.test.model.StudyProgram;
import com.example.test.persistence.StudyProgramRepository;
import com.example.test.service.StudyProgramService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyProgramImpl implements StudyProgramService {

    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramImpl(StudyProgramRepository studyProgramRepository) {
        this.studyProgramRepository = studyProgramRepository;
    }


    @Override
    public List<StudyProgram> getAllStudyPrograms() {
        List<StudyProgram> sp = new ArrayList<>();
        studyProgramRepository.findAll().forEach(sp::add);
        return sp;
    }

    @Override
    public StudyProgram addNew(StudyProgram studyProgram) {
        return studyProgramRepository.save(studyProgram);
    }

    @Override
    public StudyProgram delete(Long id) {

        StudyProgram sp = studyProgramRepository.findById(id).orElse(null);
        studyProgramRepository.delete(sp);
        return sp;
    }
}
