package com.codingdojo.peru.ft2022.relationships.controllers;

import com.codingdojo.peru.ft2022.relationships.models.License;
import com.codingdojo.peru.ft2022.relationships.models.Person;
import com.codingdojo.peru.ft2022.relationships.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons/new")
    public String showNewPersonForm(@ModelAttribute("person")Person person) {
        return "newperson.jsp";
    }

    @PostMapping("/persons/new")
    public String saveNewPerson(@Valid @ModelAttribute("person")Person person, BindingResult result) {
        if (result.hasErrors()) return "newperson.jsp";
        else {
            personService.createPerson(person);
            return "redirect:/licenses/new";
        }
    }

    @GetMapping("/persons/{id}")
    public String showPerson(@PathVariable Long id, Model model) {
        Person person = personService.findPersonById(id);
        model.addAttribute("person", person);
        return "showperson.jsp";
    }
}
