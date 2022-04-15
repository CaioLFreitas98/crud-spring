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

import br.edu.ifms.crudspring.Model.Turma;
import br.edu.ifms.crudspring.Service.TurmaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/turma")
@Slf4j
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @PostMapping("/")
    public String save(@ModelAttribute("turma") Turma turma) {
        turmaService.saveTurma(turma);
        return "redirect:/turma/";

    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Turma> turmas = turmaService.getTurma();
        model.addAttribute("Turmas", turmas);
        return "indexTurma";

    }

    @GetMapping("/cadastrar")
    public String newTurma(Model model) {
        model.addAttribute("turma", new Turma());
        return "cadTurma";
    }

    @GetMapping("/remove/{id}")
    public String removeTurma(@PathVariable("id") UUID id) {
        turmaService.delete(id);
        return "redirect:/turma/";
    }

    @GetMapping("/edit/{id}")
    public String editturma(@PathVariable("id") UUID id, Model model) {
        log.info("id = edit", id);
        Turma turma = turmaService.findById(id);
        model.addAttribute("turma", turma);
        return "editarTur";

    }

    @PostMapping("/update/{id}")
    public String updateTurma(@PathVariable("id") UUID id, @ModelAttribute Turma turma) {

        turmaService.saveTurma(turma);
        return "redirect:/turma/";
    }

}
