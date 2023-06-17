package io.github.biojj.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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
}
