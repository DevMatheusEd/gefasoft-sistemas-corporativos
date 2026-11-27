package br.com.gefasoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FuncionarioRequestDTO(

        @NotBlank
        @Size(min = 3, max = 50)
        String nome,

        @NotBlank
        @Size(min = 2, max = 50)
        @NotNull
        String funcao
) {}