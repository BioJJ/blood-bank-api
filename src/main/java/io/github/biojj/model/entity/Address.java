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

    @Builder
    public Address(String cep, String endereco,String numero,String bairro,String cidade,String estado){
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

    }

}
