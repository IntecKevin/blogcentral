package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.model.Comment;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import be.intecbrussel.blogcentral.repositories.CommentRepo;
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
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/author/createComment")

    public String showArticleForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "author/createComment";
    }

    @PostMapping("/pro/process_comment")
    public String processPosting(Comment comment) {
        commentRepo.save(comment);
        return "redirect:/author/createComment";
    }
}
