package ru.navga228.springcourse.controllers;

import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String HelloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String GoodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String Calculator(@RequestParam(value = "a", required = false) double firstValue,
                             @RequestParam(value = "b", required = false) double secondValue,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        double result;
        switch (action){
            case "multiplication":
                result = firstValue * secondValue;
                break;
            case "addition":
                result = firstValue + secondValue;
                break;
            case "subtraction":
                result = firstValue - secondValue;
                break;
            case "division":
                result = firstValue / secondValue;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result);

        return "first/calculator";
    }

}
