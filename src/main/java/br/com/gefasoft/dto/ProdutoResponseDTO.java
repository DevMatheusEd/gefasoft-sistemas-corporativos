package br.com.gefasoft.dto;

import br.com.gefasoft.model.Produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        BigDecimal precoUnitario,
        String unidadeMedida,
        String tipoEmbalagem,
        Long proprietarioId
) {
    public ProdutoResponseDTO(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPrecoUnitario(),
                produto.getUnidadeMedida(),
                produto.getTipoEmbalagem(),
                produto.getProprietario().getId()
        );
    }
}
