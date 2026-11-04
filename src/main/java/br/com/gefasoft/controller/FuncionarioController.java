package br.com.gefasoft.controller;

import br.com.gefasoft.dto.FuncionarioRequestDTO;
import br.com.gefasoft.dto.FuncionarioResponseDTO;
import br.com.gefasoft.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    // POST /funcionarios (Cadastrar)
    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> cadastrar(@RequestBody FuncionarioRequestDTO dto) {
        FuncionarioResponseDTO response = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /funcionarios (Listar todos)
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET /funcionarios/{id} (Buscar por ID)
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // PUT /funcionarios/{id} (Atualizar)
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody FuncionarioRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // DELETE /funcionarios/{id} (Excluir)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}