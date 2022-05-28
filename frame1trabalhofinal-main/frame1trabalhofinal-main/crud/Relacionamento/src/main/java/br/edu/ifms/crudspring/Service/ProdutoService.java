package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Produto;
import br.edu.ifms.crudspring.Repositories.ProdutoRepository;

@Service

public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getProduto() {
        return produtoRepository.findAll();
    }

    public void saveProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

}
