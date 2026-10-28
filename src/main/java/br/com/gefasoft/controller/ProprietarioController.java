package br.com.gefasoft.controller;

import br.com.gefasoft.dto.FuncionarioRequestDTO;
import br.com.gefasoft.dto.FuncionarioResponseDTO;
import br.com.gefasoft.dto.ProprietarioRequestDTO;
import br.com.gefasoft.dto.ProprietarioResponseDTO;
import br.com.gefasoft.model.Proprietario;
import br.com.gefasoft.service.FuncionarioService;
import br.com.gefasoft.service.ProprietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietario")
@RequiredArgsConstructor
public class ProprietarioController {
    private final ProprietarioService service;

    @PostMapping
    public ResponseEntity<ProprietarioResponseDTO> cadastrar(@RequestBody ProprietarioRequestDTO dto) {
        ProprietarioResponseDTO response = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProprietarioResponseDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}
