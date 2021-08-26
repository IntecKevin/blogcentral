package be.intecbrussel.blogcentral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorBlogHomeController {


    @GetMapping("/authorBlogHome")
    public String authorBlogHome() {

        return "authorBlogHome";
    }

}
