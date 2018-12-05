package com.example.test.service;


import com.example.test.model.StudyProgram;

import java.util.List;

public interface StudyProgramService {

    List<StudyProgram> getAllStudyPrograms();

    StudyProgram addNew(StudyProgram studyProgram);

    StudyProgram delete(Long id);
}
