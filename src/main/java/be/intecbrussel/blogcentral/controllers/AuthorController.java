package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import be.intecbrussel.blogcentral.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepo repo;

    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new Author());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegistering(Author author) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(author.getPassword());
        author.setPassword(encodedPassword);

        repo.save(author);
        return "registerSuccess";
    }

    @GetMapping("/registerSuccess")
    public String SuccessPage(Model model) {

        return "registerSuccess";
    }

    @GetMapping("/AuthorSettingPage")
    public String AprofilePage(Model model) {

        return "AuthorSettingPage";
    }

    //delete author
    @RequestMapping("/delete-author")
    public String deleteAuthor(@RequestParam Long id, HttpServletRequest request) {
        authorService.deleteMyAuthor(id);
        return "index";
    }

    //edit author
    @RequestMapping("/edit-author")
    public String editAuthor(@RequestParam Long id, HttpServletRequest request) {
        request.setAttribute("author",authorService.editAuthor(id));
        request.setAttribute("mode","MODE_UPDATE");
        return "index";
    }

}
