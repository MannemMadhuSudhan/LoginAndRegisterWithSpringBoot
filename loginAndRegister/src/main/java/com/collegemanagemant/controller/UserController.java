
package com.collegemanagemant.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.collegemanagemant.entity.User;
import com.collegemanagemant.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Default route to open index.jsp
    @GetMapping("/")
    public String index() {
        return "index"; // Direct to index.jsp
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Direct to login page
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("username", username);
            session.setAttribute("branch", user.getBranch()); // Store branch in session
            return "redirect:/branch"; // Redirect to branch page after login
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // If login fails, stay on login page
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Direct to registration page
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, 
                           @RequestParam String branch, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setBranch(branch);

        userService.register(user);
        model.addAttribute("success", "Registration successful! Please login.");
        return "redirect:/login"; // After successful registration, redirect to login
    }

    @GetMapping("/branch")
    public String branchPage(HttpSession session) {
        String branch = (String) session.getAttribute("branch");
        
        // Redirect based on the user's branch
        if ("arts".equals(branch)) {
            return "arts"; // Arts branch page
        } else if ("science".equals(branch)) {
            return "science"; // Science branch page
        } else if ("engineering".equals(branch)) {
            return "engineering"; // Engineering branch page
        }

        return "index"; // Default to index page if no branch found
    }
}
