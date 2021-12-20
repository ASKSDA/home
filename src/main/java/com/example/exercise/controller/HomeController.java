package com.example.exercise.controller;

import com.example.exercise.domain.Log;
import com.example.exercise.domain.User;
import com.example.exercise.service.LogService;
import com.example.exercise.service.LoginService;
import com.example.exercise.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class HomeController {
    @Autowired
    private SignInService signInService;

    @Autowired
    private LogService logService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toSignIn")
    public String toSignIn() {
        return "signIn";
    }

    @RequestMapping("/signIn")
    public String signIn(String email, String password) {
        if (signInService.signIn(email, password) != null)
            return "login";
        else
            return "signIn";
    }

    @RequestMapping("/login")
    public String login(String email, String password, Model model) {
        User user = loginService.login(email, password);
        if (user == null)
            return "login";
        else
            model.addAttribute("user", user);
            return "redirect:/logs";
    }

    @RequestMapping("/logs")
    public String logs(Model model, @SessionAttribute User user){
        model.addAttribute("logs", logService.showLogsByUser(user.getEmail()));
        return "logs";
    }
}