package io.github.biojj.rest;


import io.github.biojj.model.entity.Candidate;
import io.github.biojj.rest.dto.CandidateDTO;
import io.github.biojj.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CandidateController {

    private final CandidateService service;

    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @GetMapping
    public List<Candidate> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Candidate save(@RequestBody @Valid CandidateDTO candidate) {
        return service.save(candidate);
    }

    @GetMapping("{id}")
    public Candidate findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        service.delete(id);

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Candidate clienteAtualizado) {
        service.update(id, clienteAtualizado);
    }
}
