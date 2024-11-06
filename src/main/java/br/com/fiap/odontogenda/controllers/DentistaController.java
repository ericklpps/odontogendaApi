package br.com.fiap.odontogenda.controllers;

import br.com.fiap.odontogenda.dto.CreatedDTO;
import br.com.fiap.odontogenda.dto.DentistaDTO;
import br.com.fiap.odontogenda.services.DentistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public ResponseEntity<CreatedDTO> criar(@RequestBody DentistaDTO dentistaDTO) {
        DentistaDTO dentistaSaved = dentistaService.salvar(dentistaDTO);
        return ResponseEntity.status(201).body(new CreatedDTO(dentistaSaved.getId()));
    }

    @GetMapping
    public ResponseEntity<List<DentistaDTO>> listar() {
        List<DentistaDTO> dentistaDTOS = dentistaService.listar();
        return ResponseEntity.ok(dentistaDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaDTO> consultarPorId(@PathVariable String id) {
        DentistaDTO dentistaDTO = dentistaService.consultar(id);
        return ResponseEntity.ofNullable(dentistaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody DentistaDTO dentistaDTO) {
        dentistaService.atualizar(id, dentistaDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        dentistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
