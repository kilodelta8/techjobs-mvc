package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    //1. To-DONE!!!!!!
    @RequestMapping(value="results")
    public String search(Model model,
                         @RequestParam String srchTerm,
                         @RequestParam String srchType){
        ArrayList<HashMap<String, String>> filtJobs;

        if(srchType.equals("all")) {
            filtJobs = JobData.findByValue(srchTerm);
        } else {
            filtJobs = JobData.findByColumnAndValue(srchType, srchTerm);
        }
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobPosts", filtJobs);
        return "search";
    }
}
