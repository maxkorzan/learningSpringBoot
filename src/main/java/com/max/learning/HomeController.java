package com.max.learning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("myvar", "Say hello to the people.");
        model.addAttribute("hello", "helloe messages iands;fka;dfa :)");
        model.addAttribute("key", "the key is to be happy");
        return "hometemplate";
    }

    @RequestMapping("/loadform")
    public String loadFormPage(){
        return "formtemplate";
    }
    @RequestMapping("/processform")
    public String loadFormPage(@RequestParam("login") String login, Model model){
        model.addAttribute("loginval", login);
        return "confirm";
    }

//    @GetMapping("/songform")
//    public String loadFormPage(Model model){
//        model.addAttribute("song", new Song());
//        return "songform";
//    }
//
//    @PostMapping("/songform")
//    public String loadFromPage(@ModelAttribute Song song, Model model){
//        model.addAttribute("song",song);
//        return "confirmsong";
//    }


//    @GetMapping("/employeeform")
//    public String loadFormPage(Model model){
//        model.addAttribute("employee", new Employee());
//        return "employeeform";
//    }
//
//    @PostMapping("/employeeform")
//    public String loadFromPage(@ModelAttribute Employee employee, Model model) {
//        model.addAttribute("employee", employee);
//        return "employeeconfirm";
//    }

    @GetMapping("/tvform")
    public String loadTvForm(Model model){
        model.addAttribute("tvshow", new Tvshow());
        return "tvform";
    }

    @PostMapping("/tvform")
    public String processTvForm(@Valid Tvshow tvshow, BindingResult result){
        if (result.hasErrors()){
            return "tvform";
        }
        return "tvshowconfirm";
    }

}
