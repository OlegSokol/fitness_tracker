package com.fitnesstracker.controller;

import com.fitnesstracker.model.Goal;
import com.fitnesstracker.model.GoalReport;
import com.fitnesstracker.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("goal")
public class GoalController {

    @Autowired
    private GoalService service;

    @RequestMapping(value = "/addGoal", method = RequestMethod.GET)
    public String addGaol(Model model) {
        Goal goal = new Goal();
        goal.setMinutes(10);
        model.addAttribute("goal", goal);

        return "addGoal";
    }

    @RequestMapping(value = "/addGoal", method = RequestMethod.POST)
    public String updateGaol(@Valid @ModelAttribute("goal") Goal goal, Model model, BindingResult result) {
        System.out.println("result has errors: " + result.hasErrors());
        System.out.println("Minutes updated: " + goal.getMinutes());
        if(result.hasErrors()) {
            return "addGoal";
        }
        //service.save(goal);
        return "redirect:addMinutes.html";
    }

    @RequestMapping(value = "/getGoals", method = RequestMethod.GET)
    public String getGoals(Model mode) {
        List<Goal> goals = service.findAll();

        mode.addAttribute("goals", goals);

        return "getGoals";
    }

    @RequestMapping(value = "/getGoalReports", method = RequestMethod.GET)
    public String getGoalReporst(Model model) {
        List<GoalReport> goalReports = service.findAllGoalReports();

        model.addAttribute("goalReports", goalReports);

        return "getGoalReports";
    }
}
