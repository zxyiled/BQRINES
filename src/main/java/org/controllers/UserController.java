package org.controllers;

import org.models.User;
import org.models.enums.Rol;
import org.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasRole('GERENTE')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Rol.values());
        return "users/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user, RedirectAttributes flash) {
        userService.save(user);
        flash.addFlashAttribute("success", "User created successfully.");
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", Rol.values());
        return "users/form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute User user, RedirectAttributes flash) {
        userService.update(id, user);
        flash.addFlashAttribute("success", "User updated successfully.");
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes flash) {
        userService.delete(id);
        flash.addFlashAttribute("success", "User deleted successfully.");
        return "redirect:/users";
    }
}