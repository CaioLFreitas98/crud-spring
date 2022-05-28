package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Funcionario;
import br.edu.ifms.crudspring.Repositories.FuncionarioRepository;

@Service

public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void saveFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public void delete(UUID id) {
        funcionarioRepository.deleteById(id);
    }

}
