package org.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Spring Security handles POST /login automatically via SecurityConfig
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    // Redirect root to login
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }
}