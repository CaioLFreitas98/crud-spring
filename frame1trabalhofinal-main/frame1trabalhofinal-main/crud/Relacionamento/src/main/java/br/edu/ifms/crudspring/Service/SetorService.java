package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Setor;
import br.edu.ifms.crudspring.Repositories.SetorRepository;

@Service

public class SetorService {

    @Autowired
    SetorRepository setorRepository;

    public List<Setor> getSetor() {
        return setorRepository.findAll();
    }

    public void saveSetor(Setor setor) {
        setorRepository.save(setor);
    }

    public void delete(UUID id) {
        setorRepository.deleteById(id);
    }

}
