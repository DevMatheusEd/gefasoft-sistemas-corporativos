package br.com.gefasoft.dto;

import br.com.gefasoft.model.Produto;
import br.com.gefasoft.model.UnidadeMedida;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        UnidadeMedida unidadeMedida,
        String tipoEmbalagem
) {
    public ProdutoResponseDTO(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getUnidadeMedida(),
                produto.getTipoEmbalagem()
        );
    }
}
