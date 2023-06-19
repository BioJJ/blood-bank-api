package io.github.biojj.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CandidateDTO {

    private String nome;

    private String cpf;

    private String rg;

    private String data_nasc;

    private String sexo;

    private String mae;

    private String pai;

    private String email;

    private String cep;

    private String endereco;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String telefone_fixo;

    private String celular;

    private String altura;

    private String peso;

    private String tipo_sanguineo;
}
