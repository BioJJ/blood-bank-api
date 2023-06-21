package io.github.biojj.service;

import io.github.biojj.model.entity.Address;
import io.github.biojj.model.entity.Candidate;
import io.github.biojj.model.repository.CandidateRepository;
import io.github.biojj.rest.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository repository;

    private final AddressService addressService;

    public CandidateService(CandidateRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public Page<Candidate> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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

    public List<Candidate> saveAll(List<CandidateDTO> candidateBath) {

        List<Candidate> candidateList = new ArrayList<>();

        for (CandidateDTO candidate : candidateBath) {
            repository.save(
                    Candidate.builder()
                            .nome(candidate.getNome())
                            .mae(candidate.getMae())
                            .pai(candidate.getPai())
                            .rg(candidate.getRg())
                            .email(candidate.getEmail())
                            .cpf(candidate.getCpf())
                            .sexo(candidate.getSexo())
                            .data_nasc(candidate.getData_nasc())
                            .address(
                                    addressService.save(Address.builder()
                                            .cep(candidate.getCep())
                                            .bairro(candidate.getBairro())
                                            .cidade(candidate.getCidade())
                                            .estado(candidate.getEstado())
                                            .numero(candidate.getNumero())
                                            .endereco(candidate.getEndereco())
                                            .build()))
                            .telefone_fixo(candidate.getTelefone_fixo())
                            .tipo_sanguineo(candidate.getTipo_sanguineo())
                            .peso(candidate.getPeso())
                            .altura(candidate.getAltura())
                            .build());
        }

        return candidateList;
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

    public List<CandidatesByState> countCandidatesByState() {
        List<Object[]> results = repository.countCandidatesByState();

        List<CandidatesByState> candidatesByStates = new ArrayList<>();

        for (Object[] result : results) {
            String estado = (String) result[0];
            BigInteger countBigInteger = (BigInteger) result[1];
            Integer count = countBigInteger.intValue();

            candidatesByStates.add(CandidatesByState.builder().state(estado).amount(count).build());
        }

        return candidatesByStates;
    }

    public List<AverageAgeByBloodType> averageAgeByBloodType() {
        List<Object[]> results = repository.averageAgeByBloodType();

        List<AverageAgeByBloodType> averageAgeByBloodTypes = new ArrayList<>();

        for (Object[] result : results) {
            String bloodType = (String) result[0];
            BigDecimal average = (BigDecimal) result[1];

            averageAgeByBloodTypes.add(AverageAgeByBloodType.builder().bloodType(bloodType).average(average).build());
        }

        return averageAgeByBloodTypes;
    }

    public List<DonorsForEachBloodType> donorsForEachBloodType() {
        List<Object[]> results = repository.donorsForEachBloodType();

        List<DonorsForEachBloodType> donorsForEachBloodTypes = new ArrayList<>();

        for (Object[] result : results) {
            String bloodType = (String) result[0];
            BigInteger quantityBigInteger = (BigInteger) result[1];
            BigDecimal quantity = new BigDecimal(quantityBigInteger);

            donorsForEachBloodTypes.add(DonorsForEachBloodType.builder().receiver(bloodType).quantity(quantity).build());
        }

        return donorsForEachBloodTypes;
    }

    public List<PercentObese> percentObeseMen() {
        List<Object[]> results = repository.percentObeseMen();

        return getPercentObese(results);
    }

    public List<PercentObese> percentageObeseWoman() {
        List<Object[]> results = repository.percentageObeseWoman();

        return getPercentObese(results);
    }

    private List<PercentObese> getPercentObese(List<Object[]> results) {
        List<PercentObese> percentObeseList = new ArrayList<>();

        for (Object[] result : results) {
            BigInteger totalBigInteger = ((BigInteger) result[0]);
            BigInteger quantityBigInteger = ((BigInteger) result[1]);
            BigDecimal percentageObese = ((BigDecimal) result[2]);

            BigDecimal total = new BigDecimal(totalBigInteger);
            BigDecimal totalObese = new BigDecimal(quantityBigInteger);

            percentObeseList.add(PercentObese.builder().total(total).totalObese(totalObese).percentageObese(percentageObese).build());
        }

        return percentObeseList;
    }
}
