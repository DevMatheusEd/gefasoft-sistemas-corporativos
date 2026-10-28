package br.com.gefasoft.service;

import br.com.gefasoft.dto.FuncionarioRequestDTO;
import br.com.gefasoft.dto.FuncionarioResponseDTO;
import br.com.gefasoft.model.Funcionario;
import br.com.gefasoft.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioResponseDTO cadastrar(FuncionarioRequestDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setFuncao(dto.funcao());

        funcionario = repository.save(funcionario);
        return new FuncionarioResponseDTO(funcionario);
    }

    public List<FuncionarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(FuncionarioResponseDTO::new)
                .toList();
    }
}