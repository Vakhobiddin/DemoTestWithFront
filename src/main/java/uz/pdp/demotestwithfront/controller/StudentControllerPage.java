package uz.pdp.demotestwithfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentControllerPage {

    @GetMapping("/secondPage")
    public String addStudent(){

        return "secondPage";
    }

    @GetMapping("/save")
    public String save(){


        return "redirect:/";
    }
}
