package com.fitnesstracker.service;

import com.fitnesstracker.model.Activity;

import java.util.List;

public interface ExerciseService {

	List<Activity> findAllActivities();

}