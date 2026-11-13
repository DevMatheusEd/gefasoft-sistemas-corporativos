package br.com.gefasoft.dto;

import jakarta.validation.constraints.NotNull;

public record FuncionarioRequestDTO(
        @NotNull
        String nome,
        @NotNull
        String funcao
) {}
