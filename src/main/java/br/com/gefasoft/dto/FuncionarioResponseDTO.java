package br.com.gefasoft.dto;

import br.com.gefasoft.model.Funcionario;

public record FuncionarioResponseDTO(
        Long id,
        String nome,
        String funcao
) {
    public FuncionarioResponseDTO(Funcionario funcionario) {
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getFuncao()
        );
    }
}