package com.example.test.persistence;

import com.example.test.model.StudyProgram;

import java.util.Optional;

public interface StudyProgramRepository extends StudyProgramBaseRepository<StudyProgram, Long> {

    Optional<StudyProgram> findByName(String name);

    boolean existsByName(String name);
}
