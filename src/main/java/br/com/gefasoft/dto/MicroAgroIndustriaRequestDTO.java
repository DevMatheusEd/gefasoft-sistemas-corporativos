package br.com.gefasoft.dto;

import jakarta.validation.constraints.NotNull;

public record MicroAgroIndustriaRequestDTO(@NotNull
                                           String nome,
                                           @NotNull
                                           Long proprietarioId) {
}
