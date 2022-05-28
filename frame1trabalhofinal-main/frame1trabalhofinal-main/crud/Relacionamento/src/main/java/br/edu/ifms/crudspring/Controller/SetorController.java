package br.edu.ifms.crudspring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Setor;
import br.edu.ifms.crudspring.Service.SetorService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/setor")
@Slf4j
public class SetorController {

    @Autowired
    SetorService setorService;

    @GetMapping("/")
    public String listSetor(Model model) {
        log.info("listando Setor...");
        List<Setor> setors = setorService.getSetor();
        model.addAttribute("setors", setors);
        return "list-setor";

    }

    @GetMapping("/novo")
    public String novaSetor(Model model) {
        model.addAttribute("setor", new Setor());
        return "cadastrar-setor";
    }

    @PostMapping("/save")
    public String saveSetor(@ModelAttribute("turma") Setor setor) {
        setorService.saveSetor(setor);
        return "redirect:/setor/";
    }

}
