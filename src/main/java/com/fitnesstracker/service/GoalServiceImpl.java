package com.fitnesstracker.service;

import com.fitnesstracker.model.Goal;
import com.fitnesstracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Transactional
    @Override
    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }
}
