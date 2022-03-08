package com.codingdojo.peru.ft2022.relationships.controllers;

import com.codingdojo.peru.ft2022.relationships.models.License;
import com.codingdojo.peru.ft2022.relationships.models.Person;
import com.codingdojo.peru.ft2022.relationships.services.LicenseService;
import com.codingdojo.peru.ft2022.relationships.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LicenseController {
    @Autowired
    LicenseService licenseService;

    @Autowired
    PersonService personService;

    @GetMapping("/licenses/new")
    public String showNewLicenseForm(@ModelAttribute("license") License license, Model model) {
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "newlicense.jsp";
    }

    @PostMapping("/licenses/new")
    public String saveNewLicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
        if (result.hasErrors()) return "newlicense.jsp";
        else {
            license.setNumber("0000" + license.getPerson().getId());
            licenseService.createLicense(license);
            return "redirect:/persons/" + license.getPerson().getId();
        }
    }
}
