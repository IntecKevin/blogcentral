package be.intecbrussel.blogcentral.controllers;


import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.services.CustomAuthorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class SearchController {

    /*
    Need to add the search method at the CustomAuthorDetailService and front end page

    @Autowired
    CustomAuthorDetailService customAuthorDetailService;

    public String search(@Param("keyword") String keyword, Model model){
        List<Author> searchResult = customAuthorDetailService.search(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageTitle", "Search result for ' " + keyword + " ' ");
        model.addAttribute("searchResult", searchResult );
        return "search_result";

    }

     */
}
