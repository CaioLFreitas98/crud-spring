package br.edu.ifms.crudspring.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    UUID id;
    private String name;
    private double salario;

    // relacionamento OneToOne com Gerente
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "Setor_ID")
    private Setor setor;

}
