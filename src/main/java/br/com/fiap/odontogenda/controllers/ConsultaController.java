package br.com.fiap.odontogenda.controllers;

import br.com.fiap.odontogenda.dto.ConsultaDTO;
import br.com.fiap.odontogenda.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> marcar(@RequestBody ConsultaDTO consultaDTO) {
        ConsultaDTO savedConsultaDTO = consultaService.marcar(consultaDTO);
        return new ResponseEntity<>(savedConsultaDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desmarcar(@PathVariable String id) {
        consultaService.cancelar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
