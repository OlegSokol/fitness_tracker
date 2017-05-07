package com.fitnesstracker.repository;

import com.fitnesstracker.model.Exercise;

public interface ExerciseRepository {
    Exercise save(Exercise exercise);
}
