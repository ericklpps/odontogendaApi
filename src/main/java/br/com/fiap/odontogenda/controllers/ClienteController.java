package br.com.fiap.odontogenda.controllers;

import br.com.fiap.odontogenda.dto.CreatedDTO;
import br.com.fiap.odontogenda.dto.ClienteDTO;
import br.com.fiap.odontogenda.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<CreatedDTO> criar(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteSaved = clienteService.salvar(clienteDTO);
        return ResponseEntity.status(201).body(new CreatedDTO(clienteSaved.getId()));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        List<ClienteDTO> clienteDTOS = clienteService.listar();
        return ResponseEntity.ok(clienteDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> consultarPorId(@PathVariable String id) {
        ClienteDTO clienteDTO = clienteService.consultar(id);
        return ResponseEntity.ofNullable(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.atualizar(id, clienteDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
