package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.exception.PessoaNotFoundException;
import br.edu.universidadedevassouras.SCP.model.dto.PessoaCreateRequest;
import br.edu.universidadedevassouras.SCP.model.dto.PessoaResponse;
import br.edu.universidadedevassouras.SCP.model.dto.PessoaUpdateRequest;
import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<PessoaResponse> listAll() {
        var resultado = repository.findAll();

        return resultado.stream().map(pessoa -> new PessoaResponse(
                pessoa.getId(),
                pessoa.getCpf(),
                pessoa.getNome(),
                pessoa.getMatricula(),
                pessoa.getDataNascimento(),
                pessoa.getGenero(),
                pessoa.getFoto()
        )).collect(Collectors.toList());
    }

    public PessoaResponse getById(Long id) {
        var resultado = repository.findById(id);
        if (resultado.isEmpty()) {
            throw new PessoaNotFoundException();
        }
        Pessoa pessoa = resultado.get();

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

    public PessoaResponse create(PessoaCreateRequest request) {
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

    public PessoaResponse update(Long id, PessoaUpdateRequest request) {
        var resultado = repository.findById(id);
        if (resultado.isEmpty()) {
            throw new PessoaNotFoundException();
        }
        var pessoa = resultado.get();
        pessoa.setDataNascimento(request.getDataNascimento());
        pessoa.setFoto(request.getFoto());
        var pessoaSalva = repository.save(pessoa);

        return new PessoaResponse(
                pessoaSalva.getId(),
                pessoaSalva.getCpf(),
                pessoaSalva.getNome(),
                pessoaSalva.getMatricula(),
                pessoaSalva.getDataNascimento(),
                pessoaSalva.getGenero(),
                pessoaSalva.getFoto()
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
