package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Article;
import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    public ArticleController(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping("/author/createArticle")
    public String showArticleForm(Model model) {
        model.addAttribute("article", new Article()); // add new article

//        model.addAttribute("articles", articleRepo.findAllById(Author, Long) );

        return "author/createArticle";
    }

    @PostMapping("/pro/process_article")
    public String processPosting(Article article) {
        articleRepo.save(article);
        return "redirect:/author/authorBlogHome";
    }

    @GetMapping("/listArticles")
    public String listArticles (Model model){
        model.addAttribute("articles", articleRepo.findAll()); // calling all articles


        return "listArticles";

    }


}
