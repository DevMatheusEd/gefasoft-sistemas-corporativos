package br.com.gefasoft.dto;

import br.com.gefasoft.model.UnidadeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório.")
        String nome,

        @NotNull(message = "A unidade de medida é obrigatória.")
        UnidadeMedida unidadeMedida,

        @NotBlank(message = "O tipo de embalagem é obrigatório.")
        String tipoEmbalagem
) {
}
