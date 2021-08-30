package be.intecbrussel.blogcentral.controllers;

import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import be.intecbrussel.blogcentral.repositories.AuthorProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorProfileRepo prorepo;

    @Autowired
    private AuthorRepo repo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/process_SettingPage")
    public String processProfile (Author author){
        prorepo.findById(author.getId());
        return "authorProfileSettingPage";
    }

    @PostMapping("/process_edit_profile")
    public String processEditProfile(Author author) {
//        prorepo.save(prorepo.getById(author.getId()));
//        System.out.println(author);
        prorepo.save(author);
        return "index";
    }

//    @PostMapping("/process_delete_profile")
//    public String processDeleteProfile(Author author) {
//        prorepo.deleteById(author.getId());
//        return "index";
//    }

//    @GetMapping("/AuthorSettingPage")
//    public String AprofilePage(Model model) {
//
//        return "authorProfileSettingPage";
//    }

}
