package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepo articleRepo;

    @GetMapping("/article")
    public String showArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "article";
    }

    @PostMapping("/process_article")
    public String processPosting(Article article) {
        articleRepo.save(article);
        return "article";
    }


}
