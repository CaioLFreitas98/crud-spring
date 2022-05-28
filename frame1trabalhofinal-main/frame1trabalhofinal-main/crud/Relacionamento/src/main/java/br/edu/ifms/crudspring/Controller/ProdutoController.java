package br.edu.ifms.crudspring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Produto;
import br.edu.ifms.crudspring.Service.ProdutoService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/produto")
@Slf4j
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/")
    public String listProduto(Model model) {
        log.info("listando Produto...");
        List<Produto> produtos = produtoService.getProduto();
        model.addAttribute("produtos", produtos);
        return "list-produto";

    }

    @GetMapping("/novo")
    public String novaProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar-produto";
    }

    @PostMapping("/save")
    public String saveProduto(@ModelAttribute("produto") Produto produto) {
        produtoService.saveProduto(produto);
        return "redirect:/produto/";
    }

}
