package be.intecbrussel.blogcentral.controllers;


import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import be.intecbrussel.blogcentral.repositories.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegisterController {

    @Autowired
    private AuthorRepo repo;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("user", new Author());
            return "register";
        }

        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        return "register";
    }

    @PostMapping("/process_register")
    public String processRegistering(Author author) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(author.getPassword());
        author.setPassword(encodedPassword);
        repo.save(author);
        return "login";
    }
}
