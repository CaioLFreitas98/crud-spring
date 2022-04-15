package br.edu.ifms.crudspring.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Professor;
import br.edu.ifms.crudspring.Service.ProfessorService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/professor")
@Slf4j
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/")
    public String save(@ModelAttribute("professor") Professor professor) {
        professorService.saveProfessor(professor);
        return "redirect:/professor/";

    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Professor> professors = professorService.getProfessor();
        model.addAttribute("Professors", professors);
        return "indexProfessor";

    }

    @GetMapping("/cadastrar")
    public String newProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "cadProfessor";
    }

    @GetMapping("/remove/{id}")
    public String removeProfessor(@PathVariable("id") UUID id) {
        professorService.delete(id);
        return "redirect:/professor/";
    }

    @GetMapping("/edit/{id}")
    public String editprofessor(@PathVariable("id") UUID id, Model model) {
        log.info("id = edit", id);
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "editarProf";

    }

    @PostMapping("/update/{id}")
    public String updateProfessor(@PathVariable("id") UUID id, @ModelAttribute Professor professor) {

        professorService.saveProfessor(professor);
        return "redirect:/professor/";
    }

}
