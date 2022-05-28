package br.edu.ifms.crudspring.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    UUID id;
    private String name;
    private String localização;

    // relacionamento ManyToMany com Produtos
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Armazem_e_Produtos", joinColumns = { @JoinColumn(name = "Armazem_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "Produto_ID") })

    private List<Armazem> armazens;

}
