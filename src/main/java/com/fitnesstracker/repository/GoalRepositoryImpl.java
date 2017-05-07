package com.fitnesstracker.repository;

import com.fitnesstracker.model.Goal;
import com.fitnesstracker.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal save(Goal goal) {
        if(goal.getId() == null) {
            entityManager.persist(goal);
            entityManager.flush();
        } else {
            entityManager.merge(goal);
        }
        return goal;
    }

    @Override
    public List<Goal> findAll() {
        //Query query = entityManager.createQuery("select g from Goal g");

        TypedQuery<Goal> query = entityManager.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class);

        return query.getResultList();
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
        /*String sQuery = "select new com.fitnesstracker.model.GoalReport(g.minutes, e.minutes, e.activity)" +
                "from Goal g, Exercise  e where  g.id = e.goal.id";
        Query query = entityManager.createQuery(sQuery);*/
        TypedQuery<GoalReport> query = entityManager.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
        return query.getResultList();
    }
}
