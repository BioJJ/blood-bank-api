package io.github.biojj.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "zip_code")
    private String cep;

    @Column(name = "address")
    private String endereco;

    @Column(name = "number")
    private String numero;

    @Column(name = "neighborhood")
    private String bairro;

    @Column(name = "city")
    private String cidade;

    @Column(name = "state")
    private String estado;
}
