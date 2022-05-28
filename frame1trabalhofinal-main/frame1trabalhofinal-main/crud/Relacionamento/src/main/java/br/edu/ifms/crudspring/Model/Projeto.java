package br.edu.ifms.crudspring.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    UUID id;
    private String nome;
    private String cargo;
    private double gastototal;

    // relacionamento ManyToMany com Funcionario
    @ManyToMany(mappedBy = "projetos")
    private List<Projeto> projetos;

}
