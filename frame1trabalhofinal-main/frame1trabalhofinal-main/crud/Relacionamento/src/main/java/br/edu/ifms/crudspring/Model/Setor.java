package br.edu.ifms.crudspring.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    UUID id;
    private String nome;
    private double gasto;

    // relacionamento OneToOne com Setor
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "Gerente_ID")
    private Gerente gerente;

    // Relacionamento OneToMany com Funcionario
    @OneToMany(mappedBy = "Setor")
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();

}
