package br.edu.ifms.crudspring.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.crudspring.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    // conexão com o banco de dados diretamente

}
