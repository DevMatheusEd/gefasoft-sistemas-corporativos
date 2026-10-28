package br.com.gefasoft.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório.")
        String nome,

        @NotNull(message = "O preço unitário é obrigatório.")
        @DecimalMin(value = "0.01", message = "O preço unitário deve ser maior que zero.")
        BigDecimal precoUnitario,

        @NotBlank(message = "A unidade de medida é obrigatória.")
        String unidadeMedida,

        @NotBlank(message = "O tipo de embalagem é obrigatório.")
        String tipoEmbalagem,

        @NotNull(message = "O proprietário é obrigatório.")
        Long proprietarioId
) {
}
