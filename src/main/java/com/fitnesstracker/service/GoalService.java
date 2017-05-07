package com.fitnesstracker.service;

import com.fitnesstracker.model.Goal;
import com.fitnesstracker.model.GoalReport;

import java.util.List;

public interface GoalService {
    Goal save(Goal goal);

    List<Goal> findAll();

    List<GoalReport> findAllGoalReports();
}
