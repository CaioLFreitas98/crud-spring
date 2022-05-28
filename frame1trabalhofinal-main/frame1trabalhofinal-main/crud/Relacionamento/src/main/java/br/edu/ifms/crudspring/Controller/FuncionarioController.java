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
import br.edu.ifms.crudspring.Model.Setor;
import br.edu.ifms.crudspring.Service.FuncionarioService;
import br.edu.ifms.crudspring.Service.SetorService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    SetorService setorService;

    @GetMapping("/")
    public String listFuncionario(Model model) {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios = funcionarioService.getFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "list-funcionario";
    }

    @GetMapping("/novo")
    public String novoFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        List<Setor> setors = new ArrayList<Setor>();
        setors = setorService.getSetor();
        model.addAttribute("setors", setors);
        return "cadastrar-funcionario";
    }

    @PostMapping("/save")
    public String novoFuncionario(@ModelAttribute Funcionario p) {
        funcionarioService.saveFuncionario(p);
        return "redirect:/funcionario/";
    }

}
