package ed.interview.SimpleWebApp.controller;

import ed.interview.SimpleWebApp.DTO.UserDTO;
import ed.interview.SimpleWebApp.entity.User;
import ed.interview.SimpleWebApp.repository.UserRepo;
import ed.interview.SimpleWebApp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Controller
public class UserController {

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
    public String registerUser(@ModelAttribute("user") UserDTO user){
        System.out.println(user);
        service.createUser(user);
        return "homePage";
    }

    @GetMapping("/display")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
//        System.out.println(model);
        return "displayUsers";
    }
    @GetMapping("/userDetails")
    public String userDetails(@RequestParam(name = "userid") int userid,Model model) throws Exception {
        UserDTO user = service.readUser(userid);
        model.addAttribute("user",user);
        return "userDetails";
    }

}
