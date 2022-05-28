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

import br.edu.ifms.crudspring.Model.Armazem;
import br.edu.ifms.crudspring.Service.ArmazemService;

@Controller
@RequestMapping("/armazem")
public class ArmazemController {

    @Autowired
    ArmazemService armazemService;

    @GetMapping("/")
    public String listArmazem(Model model) {
        List<Armazem> armazens = new ArrayList<Armazem>();
        armazens = armazemService.getArmazem();
        model.addAttribute("armazem", armazens);
        return "list-armazem";
    }

    @GetMapping("/novo")
    public String novoArmazem(Model model) {
        model.addAttribute("armazem", new Armazem());
        return "cadastrar-armazem";
    }

    @PostMapping("/save")
    public String novoArmazem(@ModelAttribute Armazem p) {
        armazemService.saveArmazem(p);
        return "redirect:/funcionario/";
    }

}
