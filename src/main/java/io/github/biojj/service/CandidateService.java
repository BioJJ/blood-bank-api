package io.github.biojj.service;

import io.github.biojj.model.entity.Address;
import io.github.biojj.model.entity.Candidate;
import io.github.biojj.model.repository.CandidateRepository;
import io.github.biojj.rest.dto.CandidateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository repository;

    private final AddressService addressService;

    public CandidateService(CandidateRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public List<Candidate> findAll() {
        return repository.findAll();
    }

    public Candidate save(CandidateDTO candidateDTO) {

        return repository.save(
                Candidate.builder()
                        .nome(candidateDTO.getNome())
                        .mae(candidateDTO.getMae())
                        .pai(candidateDTO.getPai())
                        .rg(candidateDTO.getRg())
                        .email(candidateDTO.getEmail())
                        .cpf(candidateDTO.getCpf())
                        .sexo(candidateDTO.getSexo())
                        .data_nasc(candidateDTO.getData_nasc())
                        .address(
                                addressService.save(Address.builder()
                                        .cep(candidateDTO.getCep())
                                        .bairro(candidateDTO.getBairro())
                                        .cidade(candidateDTO.getCidade())
                                        .estado(candidateDTO.getEstado())
                                        .numero(candidateDTO.getNumero())
                                        .endereco(candidateDTO.getEndereco())
                                        .build()))
                        .telefone_fixo(candidateDTO.getTelefone_fixo())
                        .tipo_sanguineo(candidateDTO.getTipo_sanguineo())
                        .peso(candidateDTO.getPeso())
                        .altura(candidateDTO.getAltura())
                        .build());
    }

    public Candidate findById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"));
    }

    public void delete(Integer id) {
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"));
    }

    public void update(Integer id,
                       Candidate candidateDTO) {

        repository
                .findById(id)
                .map(candidate -> {
                    candidate.setNome(candidateDTO.getNome());
                    candidate.setMae(candidateDTO.getMae());
                    candidate.setPai(candidateDTO.getPai());
                    candidate.setRg(candidateDTO.getRg());
                    candidate.setEmail(candidateDTO.getEmail());
                    candidate.setCpf(candidateDTO.getCpf());
                    candidate.setSexo(candidateDTO.getSexo());
                    candidate.setData_nasc(candidateDTO.getData_nasc());
                    candidate.setTelefone_fixo(candidateDTO.getTelefone_fixo());
                    candidate.setTipo_sanguineo(candidateDTO.getTipo_sanguineo());
                    candidate.setPeso(candidateDTO.getPeso());
                    candidate.setAltura(candidateDTO.getAltura());
                    return repository.save(candidate);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
