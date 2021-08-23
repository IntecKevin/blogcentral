package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.repositories.ArticleRepo;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleControler {

    @Autowired
    private ArticleRepo articleRepo;

    @PostMapping("/process_article")
    public String processRegistering(Article article) {
        articleRepo.save(article);
        return "index";
    }
}
