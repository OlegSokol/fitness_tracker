package com.fitnesstracker.repository;

import com.fitnesstracker.model.Goal;
import com.fitnesstracker.model.GoalReport;

import java.util.List;

public interface GoalRepository {
    Goal save(Goal goal);

    List<Goal> findAll();

    List<GoalReport> findAllGoalReports();
}
