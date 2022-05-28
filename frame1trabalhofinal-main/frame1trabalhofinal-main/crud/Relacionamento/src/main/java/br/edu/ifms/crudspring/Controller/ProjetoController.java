package br.edu.ifms.crudspring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Projeto;
import br.edu.ifms.crudspring.Service.ProjetoService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/projeto")
@Slf4j
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @GetMapping("/")
    public String listProjeto(Model model) {
        log.info("listando Projeto...");
        List<Projeto> projetos = projetoService.getProjeto();
        model.addAttribute("projetos", projetos);
        return "list-projeto";

    }

    @GetMapping("/novo")
    public String novaProjeto(Model model) {
        model.addAttribute("projeto", new Projeto());
        return "cadastrar-projeto";
    }

    @PostMapping("/save")
    public String saveProjeto(@ModelAttribute("projeto") Projeto projeto) {
        projetoService.saveProjeto(projeto);
        return "redirect:/projeto/";
    }

}
