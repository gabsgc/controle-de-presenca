package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.exception.PessoaNotFoundException;
import br.edu.universidadedevassouras.SCP.model.dto.PessoaRequest;
import br.edu.universidadedevassouras.SCP.model.dto.PessoaResponse;
import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Iterable<Pessoa> listAll() {
        return repository.findAll();
    }

    public Optional<Pessoa> getById(Long id) {
        var resultado = repository.findById(id);
        if (resultado.isEmpty()) {
            throw new PessoaNotFoundException();
        }
        return repository.findById(id);
    }

    public PessoaResponse create(PessoaRequest request) {
        var novaPessoa = new Pessoa();
        novaPessoa.setCpf(request.getCpf());
        novaPessoa.setNome(request.getNome());
        novaPessoa.setMatricula(request.getMatricula());
        novaPessoa.setDataNascimento(request.getDataNascimento());
        novaPessoa.setGenero(request.getGenero());
        novaPessoa.setFoto(request.getFoto());

        var savePessoa = repository.save(novaPessoa);

        return new PessoaResponse(
                savePessoa.getId(),
                savePessoa.getCpf(),
                savePessoa.getNome(),
                savePessoa.getMatricula(),
                savePessoa.getDataNascimento(),
                savePessoa.getGenero(),
                savePessoa.getFoto()
        );
    }

    public PessoaResponse update(Long id, PessoaRequest request) {
        var resultado = repository.findById(id);
        if (resultado.isEmpty()) {
            throw new PessoaNotFoundException();
        }
        var pessoa = resultado.get();
        pessoa.setNome(request.getNome());
        pessoa.setMatricula(request.getMatricula());
        pessoa.setDataNascimento(request.getDataNascimento());
        pessoa.setGenero(request.getGenero());
        pessoa.setFoto(request.getFoto());
        var pessoaSalva = repository.save(pessoa);

        return new PessoaResponse(
                pessoa.getId(),
                pessoa.getCpf(),
                pessoa.getNome(),
                pessoa.getMatricula(),
                pessoa.getDataNascimento(),
                pessoa.getGenero(),
                pessoa.getFoto()
        );
    }

    public void delete(Long id) {
        var resultado = repository.findById(id);
        if (resultado.isEmpty()) {
            throw new PessoaNotFoundException();
        }
        Pessoa pessoa = resultado.get();
        repository.delete(pessoa);
    }
}
