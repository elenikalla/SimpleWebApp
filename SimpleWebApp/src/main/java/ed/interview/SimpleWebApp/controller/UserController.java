package ed.interview.SimpleWebApp.controller;

import ed.interview.SimpleWebApp.entity.User;
import ed.interview.SimpleWebApp.repository.UserRepo;
import ed.interview.SimpleWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "registerPage";
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

    @GetMapping("/display")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
//        System.out.println(model);
        return "displayUsers";
    }

}
