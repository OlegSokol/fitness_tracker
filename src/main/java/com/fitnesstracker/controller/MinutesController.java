package com.fitnesstracker.controller;

import com.fitnesstracker.model.Activity;
import com.fitnesstracker.model.Exercise;
import com.fitnesstracker.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MinutesController {

    @Resource(name = "exerciseService")
    private ExerciseService exerciseService;

    @RequestMapping(name = "/addMinutes")
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise, Model model, BindingResult result) {

        System.out.println("Exercise: " + exercise.getMinutes());
        System.out.println("exercise activity: " + exercise.getActivity());

        List<Activity> allActivities = exerciseService.findAllActivities();
        model.addAttribute("activities", allActivities);

        if(result.hasErrors()) {
            return "addMinutes";
        }

        return "addMinutes";
    }

    /*@RequestMapping(value = "/activities", method = RequestMethod.GET)
    @ResponseBody
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<>();

        Activity run = new Activity();
        run.setDesc("Run");
        activities.add(run);

        Activity bike = new Activity();
        bike.setDesc("Bike");
        activities.add(bike);

        Activity swim = new Activity();
        swim.setDesc("Swim");
        activities.add(swim);

        return activities;
    }*/
}
