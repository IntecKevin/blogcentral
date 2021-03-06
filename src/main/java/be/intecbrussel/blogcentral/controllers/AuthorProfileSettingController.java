package be.intecbrussel.blogcentral.controllers;


import be.intecbrussel.blogcentral.repositories.AuthorDetailImpl;
import be.intecbrussel.blogcentral.services.CustomAuthorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorProfileSettingController {

    @Autowired
    private CustomAuthorDetailService customAuthorDetailService;

    @GetMapping("/authorProfileSettingPage")
    public String authorSettingPage(@AuthenticationPrincipal AuthorDetailImpl loginAuthor,
                                    Model model) {
        if (loginAuthor == null) {
            throw new UsernameNotFoundException("User not found user with that email");
        }
        String userEmail = loginAuthor.getUsername();


        model.addAttribute("author", loginAuthor);
        model.addAttribute("authorDetail", customAuthorDetailService);


        return "authorProfileSettingPage";

    }

    /*

    public String editAuthor(){


        return null;
    }

    public String saveAuthor(){

        return null;
    }

    public String deleteAuthor(){

        return null;
    }

     */

    /*

    @RequestMapping(value = "/authorSettingPage", method = RequestMethod.GET)
    public ModelAndView showAuthorDetailProfileInfo() {
        return new ModelAndView(
        model.addAttribute("lastName", author.getLastName());
        model.addAttribute("streetName", author.streetName();
        model.addAttribute("houseNo", author.houseNo);
          );
    }

    @RequestMapping(value = "/authorSettingPage/save", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("author")Author author,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("lastName", author.getLastName());
        model.addAttribute("streetName", author.streetName();
        model.addAttribute("houseNo", author.houseNo);
        return "authorSettingPage";
    }

     */
}
