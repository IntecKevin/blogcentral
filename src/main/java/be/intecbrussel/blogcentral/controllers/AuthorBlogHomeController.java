package be.intecbrussel.blogcentral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorBlogHomeController {


    @GetMapping("/author/authorBlogHome")
    public String authorBlogHome() {

        return "/author/authorBlogHome";
    }

}
