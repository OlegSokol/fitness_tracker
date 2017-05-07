package com.fitnesstracker.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
@NamedQueries({
        @NamedQuery(name = Goal.FIND_GOAL_REPORTS, query = "select new com.fitnesstracker.model.GoalReport(g.minutes, e.minutes, e.activity)" +
                "from Goal g, Exercise  e where  g.id = e.goal.id"),
        @NamedQuery(name = Goal.FIND_ALL_GOALS, query = "select g from Goal g")
})
public class Goal {

    public static final String FIND_GOAL_REPORTS = "findGoalReports";
    public static final String FIND_ALL_GOALS = "findAllGoals";

    @Id
    @GeneratedValue
    private Long id;

    @Range(min = 1, max = 120)
    @Column(name = "minutes")
    private int minutes;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exercise> exercises = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        exercise.setGoal(this);
        exercises.add(exercise);
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", minutes=" + minutes +
                ", exercises=" + exercises +
                '}';
    }
}
