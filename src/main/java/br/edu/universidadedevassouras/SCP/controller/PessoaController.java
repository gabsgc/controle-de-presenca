package br.edu.universidadedevassouras.SCP.controller;

import br.edu.universidadedevassouras.SCP.model.dto.PessoaRequest;
import br.edu.universidadedevassouras.SCP.model.dto.PessoaResponse;
import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import br.edu.universidadedevassouras.SCP.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> getAll() {
        Iterable<Pessoa> pessoas = service.listAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Optional<Pessoa>> getPessoa(@PathVariable("id")Long id){
        Optional<Pessoa> resultado = service.getById(id);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody PessoaRequest request) {
        PessoaResponse resultado = service.create(request);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> putPessoa(@PathVariable("id") Long id, @RequestBody @Valid PessoaRequest request){
        PessoaResponse update = service.update(id, request);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}