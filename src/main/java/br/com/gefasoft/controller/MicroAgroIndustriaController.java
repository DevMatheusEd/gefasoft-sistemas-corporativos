package br.com.gefasoft.controller;

import br.com.gefasoft.dto.MicroAgroIndustriaRequestDTO;
import br.com.gefasoft.dto.MicroAgroIndustriaResponseDTO;
import br.com.gefasoft.service.MicroAgroIndustriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/micro_industrias")
@RequiredArgsConstructor
public class MicroAgroIndustriaController {
    private final MicroAgroIndustriaService service;

    @PostMapping
    public ResponseEntity<MicroAgroIndustriaResponseDTO> cadastrar (@RequestBody MicroAgroIndustriaRequestDTO dto){
        MicroAgroIndustriaResponseDTO response = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<MicroAgroIndustriaResponseDTO>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MicroAgroIndustriaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MicroAgroIndustriaResponseDTO> atualizar(@PathVariable Long id, @RequestBody MicroAgroIndustriaRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<MicroAgroIndustriaResponseDTO>> buscarPorNome(@RequestParam String nome){
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }
}
