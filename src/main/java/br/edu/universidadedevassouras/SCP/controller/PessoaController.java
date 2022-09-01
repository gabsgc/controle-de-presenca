package br.edu.universidadedevassouras.SCP.controller;

import br.edu.universidadedevassouras.SCP.model.Pessoa;
import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {
    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Pessoa> getAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id")Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}