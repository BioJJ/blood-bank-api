package io.github.biojj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "data_nasc")
    private String data_nasc;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "mother")
    private String mae;

    @Column(name = "father")
    private String pai;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "landline")
    private String telefone_fixo;

    @Column(name = "cell_phone")
    private String celular;

    @Column(name = "height")
    private String altura;

    @Column(name = "Weight")
    private String peso;

    @Column(name = "blood_type")
    private String tipo_sanguineo;

    @Builder
    public Candidate(String nome, String cpf, String rg, String data_nasc, String sexo, String mae, String pai, String email, Address address, String telefone_fixo,
                     String celular, String altura, String peso, String tipo_sanguineo) {

        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.mae = mae;
        this.pai = pai;
        this.email = email;
        this.address = address;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.altura = altura;
        this.peso = peso;
        this.tipo_sanguineo = tipo_sanguineo;


    }


}
