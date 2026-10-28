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

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> cadastrar(@RequestBody FuncionarioRequestDTO dto) {
        FuncionarioResponseDTO response = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}