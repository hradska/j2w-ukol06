package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.CitatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 */

@Controller
public class CitatyController {

    private final CitatyService citatyService;

    @Autowired
    public CitatyController(CitatyService citatyService) {
        this.citatyService = citatyService;
    }

    @GetMapping("/")
    public ModelAndView nahodnyCitat() {
        ModelAndView modelAndView = new ModelAndView("citat");
        modelAndView.addObject("citat", citatyService.nahodnyCitat());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public Object konkretniCitat(@PathVariable int id) {
        String citat = citatyService.konkretniCitat(id);
        if (citat == null) {
            return "chyba";
        }
        return new ModelAndView("citat").addObject("citat", citat);
    }
}
