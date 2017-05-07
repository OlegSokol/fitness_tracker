package com.fitnesstracker.service;

import com.fitnesstracker.model.Activity;
import com.fitnesstracker.model.Exercise;

import java.util.List;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);
}