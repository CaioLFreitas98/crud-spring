package br.edu.ifms.crudspring.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.crudspring.Model.Setor;

@Repository

public interface SetorRepository extends JpaRepository<Setor, UUID> {

}
