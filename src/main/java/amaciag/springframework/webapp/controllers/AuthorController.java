package amaciag.springframework.webapp.controllers;

import amaciag.springframework.webapp.repositories.AuthorRespository;
import amaciag.springframework.webapp.repositories.DependecyEx;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

     private final AuthorRespository authorRespository;
     private final DependecyEx dependecyEx;


    public AuthorController(AuthorRespository authorRespository, DependecyEx dependecyEx) {
        this.authorRespository = authorRespository;
        this.dependecyEx = dependecyEx;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model)
    {
        model.addAttribute("authors", authorRespository.findAll());

        return "authors/list";
    }

}
