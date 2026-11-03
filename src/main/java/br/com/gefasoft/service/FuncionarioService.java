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

    // CREATE
    public FuncionarioResponseDTO cadastrar(FuncionarioRequestDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setFuncao(dto.funcao());

        funcionario = repository.save(funcionario);
        return new FuncionarioResponseDTO(funcionario);
    }

    // READ (Listar todos)
    public List<FuncionarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(FuncionarioResponseDTO::new)
                .toList();
    }

    // READ (Buscar por ID)
    public FuncionarioResponseDTO buscarPorId(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));
        return new FuncionarioResponseDTO(funcionario);
    }

    // UPDATE
    public FuncionarioResponseDTO atualizar(Long id, FuncionarioRequestDTO dto) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + id));

        funcionario.setNome(dto.nome());
        funcionario.setFuncao(dto.funcao());

        funcionario = repository.save(funcionario);
        return new FuncionarioResponseDTO(funcionario);
    }

    // DELETE
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}