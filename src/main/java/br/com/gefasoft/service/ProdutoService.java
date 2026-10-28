package br.com.gefasoft.service;

import br.com.gefasoft.dto.ProdutoRequestDTO;
import br.com.gefasoft.dto.ProdutoResponseDTO;
import br.com.gefasoft.model.Produto;
import br.com.gefasoft.model.Proprietario;
import br.com.gefasoft.repository.ProdutoRepository;
import br.com.gefasoft.repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProprietarioRepository proprietarioRepository;

    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO dto) {
        Proprietario proprietario = proprietarioRepository.findById(dto.proprietarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietário não encontrado."));

        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPrecoUnitario(dto.precoUnitario());
        produto.setUnidadeMedida(dto.unidadeMedida());
        produto.setTipoEmbalagem(dto.tipoEmbalagem());
        produto.setProprietario(proprietario);

        Produto salvo = repository.save(produto);
        return new ProdutoResponseDTO(salvo);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }
}
