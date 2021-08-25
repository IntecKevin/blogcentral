package be.intecbrussel.blogcentral.controllers;


import be.intecbrussel.blogcentral.model.Author;
import be.intecbrussel.blogcentral.repositories.AuthorDetailImpl;
import be.intecbrussel.blogcentral.repositories.AuthorRepo;
import be.intecbrussel.blogcentral.services.CustomAuthorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileSettingController {

    @Autowired
    private CustomAuthorDetailService customAuthorDetailService;

    @GetMapping("/authorSettingPage")
    public String authorSettingPage(@AuthenticationPrincipal AuthorDetailImpl loginAuthor,
                                    Model model) {
        String userEmail = loginAuthor.getUsername();


        model.addAttribute("author", loginAuthor);
        model.addAttribute("authorDetail", customAuthorDetailService);

        return "authorSettingPage";

    }
    /*

    @RequestMapping(value = "/authorSettingPage", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView(
                model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
                );
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee")Employee employee,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employeeView";
    }

     */
}
