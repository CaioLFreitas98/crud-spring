package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Turma;
import br.edu.ifms.crudspring.Repositories.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> getTurma() {
        return turmaRepository.findAll();
    }

    public void saveTurma(Turma turma) {
        turmaRepository.save(turma);
    }

    public void delete(UUID id) {
        turmaRepository.deleteById(id);
    }

    public Turma findById(UUID id) {
        return turmaRepository.findById(id).get();
    }

}
