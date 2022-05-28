package br.edu.ifms.crudspring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Funcionario;
import br.edu.ifms.crudspring.Model.Gerente;
import br.edu.ifms.crudspring.Service.GerenteService;

@Controller
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    GerenteService gerenteService;

    @GetMapping("/")
    public String listGerente(Model model) {
        List<Gerente> gerentes = new ArrayList<Gerente>();
        gerentes = gerenteService.getGerente();
        model.addAttribute("gerentes", gerentes);
        return "list-gerentes";
    }

    @GetMapping("/novo")
    public String novoFuncionario(Model model) {
        model.addAttribute("gerentes", new Funcionario());
        return "cadastrar-gerente";
    }

    @PostMapping("/save")
    public String novoFuncionario(@ModelAttribute Gerente p) {
        gerenteService.saveGerente(p);
        return "redirect:/funcionario/";
    }

}
