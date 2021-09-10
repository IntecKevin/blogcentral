package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {



//    @Autowired
//    private AuthorProfileRepo prorepo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }



//    @GetMapping("/process_SettingPage")
//    public String processProfile (Author author){
//        prorepo.findById(author.getId());
//        return "authorProfileSettingPage";
//    }



//    @GetMapping("/AuthorSettingPage")
//    public String AprofilePage(Model model) {
//
//        return "authorProfileSettingPage";
//    }


}
