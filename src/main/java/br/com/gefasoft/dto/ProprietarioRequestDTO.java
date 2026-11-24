package br.com.gefasoft.dto;

import jakarta.validation.constraints.NotNull;

public record ProprietarioRequestDTO(@NotNull
                                     String nome,
                                     @NotNull
                                     String senha,
                                     @NotNull
                                     String email) {
}
