package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Armazem;
import br.edu.ifms.crudspring.Repositories.ArmazemRepository;

@Service

public class ArmazemService {

    @Autowired
    ArmazemRepository armazemRepository;

    public List<Armazem> getArmazem() {
        return armazemRepository.findAll();
    }

    public void saveArmazem(Armazem armazem) {
        armazemRepository.save(armazem);
    }

    public void delete(UUID id) {
        armazemRepository.deleteById(id);
    }

}
