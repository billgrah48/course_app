package com.example.course_app;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserFormController {

    @GetMapping("/test")
    public String testForm() {
        return "form_template";
    }

    @RequestMapping("/form")
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "form_template"; // Ensure that this matches with your form.html template
    }

    @PostMapping("/form")
    public String submitForm(@Valid UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form_template"; // Return to form if there are errors
        }
        model.addAttribute("successMessage", "Form submitted successfully");
        return "result"; // Ensure that this matches with your result.html template
    }
}
