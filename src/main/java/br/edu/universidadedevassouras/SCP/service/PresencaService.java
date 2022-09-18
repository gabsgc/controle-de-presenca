package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.exception.PessoaNotFoundException;
import br.edu.universidadedevassouras.SCP.exception.PresencaNotFoundException;
import br.edu.universidadedevassouras.SCP.model.dto.PresencaRequest;
import br.edu.universidadedevassouras.SCP.model.dto.PresencaResponse;
import br.edu.universidadedevassouras.SCP.model.dto.PresencaUpdateRequest;
import br.edu.universidadedevassouras.SCP.model.entity.Pessoa;
import br.edu.universidadedevassouras.SCP.model.entity.Presenca;
import br.edu.universidadedevassouras.SCP.repository.PessoaRepository;
import br.edu.universidadedevassouras.SCP.repository.PresencaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresencaService {
    private PresencaRepository presencaRepository;
    private PessoaRepository pessoaRepository;

    public PresencaService(PresencaRepository presencaRepository, PessoaRepository pessoaRepository) {
        this.presencaRepository = presencaRepository;
        this.pessoaRepository = pessoaRepository;
    }
    public PresencaResponse create(PresencaRequest request) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(request.getPessoa());
        if (pessoaEncontrada.isEmpty()) {
            throw new PessoaNotFoundException();
        }
        var pessoa = pessoaEncontrada.get();
        var novaPresenca = new Presenca();
        novaPresenca.setData(request.getData());
        novaPresenca.setSituacao(request.getSituacao());
        novaPresenca.setPessoa(pessoa);

        var savePresenca = presencaRepository.save(novaPresenca);

        return new PresencaResponse(
                savePresenca.getId(),
                savePresenca.getData(),
                savePresenca.getSituacao(),
                savePresenca.getPessoa()
        );
    }

    public PresencaResponse updateSituacao(Long id, PresencaUpdateRequest request) {
        var resultado = presencaRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new PresencaNotFoundException();
        }
        var presenca = resultado.get();
        presenca.setSituacao(request.getSituacao());
        var presencaAtualizada = presencaRepository.save(presenca);

        return new PresencaResponse(
                presencaAtualizada.getId(),
                presencaAtualizada.getData(),
                presencaAtualizada.getSituacao(),
                presencaAtualizada.getPessoa()
        );
    }
}
