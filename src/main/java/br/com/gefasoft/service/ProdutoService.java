package br.com.gefasoft.service;

import br.com.gefasoft.dto.ProdutoRequestDTO;
import br.com.gefasoft.dto.ProdutoResponseDTO;
import br.com.gefasoft.model.Produto;
import br.com.gefasoft.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setUnidadeMedida(dto.unidadeMedida());
        produto.setTipoEmbalagem(dto.tipoEmbalagem());

        Produto salvo = repository.save(produto);
        return new ProdutoResponseDTO(salvo);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
        return new ProdutoResponseDTO(produto);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));

        produto.setNome(dto.nome());
        produto.setUnidadeMedida(dto.unidadeMedida());
        produto.setTipoEmbalagem(dto.tipoEmbalagem());

        Produto atualizado = repository.save(produto);
        return new ProdutoResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado.");
        }

        repository.deleteById(id);
    }
}
