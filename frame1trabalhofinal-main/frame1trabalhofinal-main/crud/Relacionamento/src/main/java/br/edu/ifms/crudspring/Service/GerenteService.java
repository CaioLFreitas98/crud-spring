package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Gerente;
import br.edu.ifms.crudspring.Repositories.GerenteRepository;

@Service

public class GerenteService {

    @Autowired
    GerenteRepository gerenteRepository;

    public List<Gerente> getGerente() {
        return gerenteRepository.findAll();
    }

    public void saveGerente(Gerente gerente) {
        gerenteRepository.save(gerente);
    }

    public void delete(UUID id) {
        gerenteRepository.deleteById(id);
    }

}
