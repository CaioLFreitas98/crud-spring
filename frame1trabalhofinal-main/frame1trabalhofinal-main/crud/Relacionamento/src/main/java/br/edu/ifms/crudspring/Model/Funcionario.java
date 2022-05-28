package br.edu.ifms.crudspring.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String name;
    double salario;

    // relacionamento ManyToMany com Projeto
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Projeto_e_Funcionario", joinColumns = {
            @JoinColumn(name = "Funcionario_ID") }, inverseJoinColumns = { @JoinColumn(name = "Projeto_ID") })

    private List<Projeto> projetos;

    // relacionamento ManyToOne com Setor
    // Professor
    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = true)
    Setor setor;
}
