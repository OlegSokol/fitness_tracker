package com.fitnesstracker.controller;

import com.fitnesstracker.model.Activity;
import com.fitnesstracker.model.Exercise;
import com.fitnesstracker.model.Goal;
import com.fitnesstracker.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MinutesController {

    @Resource(name = "exerciseService")
    private ExerciseService exerciseService;

    @RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
    public String getMinutes(@ModelAttribute("exercise") Exercise exercise, Model model) {
        List<Activity> allActivities = exerciseService.findAllActivities();
        model.addAttribute("activities", allActivities);
        return "addMinutes";
    }

    @RequestMapping(name = "/addMinutes", method = RequestMethod.POST)
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise, HttpSession session, BindingResult result) {

        System.out.println("Exercise: " + exercise.getMinutes());
        System.out.println("exercise activity: " + exercise.getActivity());

        if(result.hasErrors()) {
            return "addMinutes";
        } else {
            Goal goal = (Goal) session.getAttribute("goal");
            exercise.setGoal(goal);
            exerciseService.save(exercise);
        }

        return "redirect:addMinutes.html";
    }
}
