package ed.interview.SimpleWebApp.controller;

import ed.interview.SimpleWebApp.entity.User;
import ed.interview.SimpleWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user){
        System.out.println(user);
        service.registerUser(user);
        return "homePage";
    }
    @RequestMapping("/display")
    public String displayUsers(){
        return "displayUsers";
    }

}
