package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Professor;
import br.edu.ifms.crudspring.Repositories.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> getProfessor() {
        return professorRepository.findAll();
    }

    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void delete(UUID id) {
        professorRepository.deleteById(id);
    }

    public Professor findById(UUID id) {
        return professorRepository.findById(id).get();
    }

}
