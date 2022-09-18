package br.edu.universidadedevassouras.SCP.controller;

import br.edu.universidadedevassouras.SCP.model.dto.PresencaRequest;
import br.edu.universidadedevassouras.SCP.model.dto.PresencaResponse;
import br.edu.universidadedevassouras.SCP.model.dto.PresencaUpdateRequest;
import br.edu.universidadedevassouras.SCP.service.PresencaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/presenca")
public class PresencaController {
    private PresencaService service;

    public PresencaController(PresencaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PresencaResponse> create(@RequestBody PresencaRequest request) {
        var resultado = service.create(request);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PresencaResponse> update(@PathVariable("id") Long id, @RequestBody PresencaUpdateRequest request) {
        var resultado = service.updateSituacao(id, request);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}