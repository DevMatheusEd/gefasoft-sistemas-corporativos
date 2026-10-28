package br.com.gefasoft.service;

import br.com.gefasoft.dto.ProprietarioRequestDTO;
import br.com.gefasoft.dto.ProprietarioResponseDTO;

import br.com.gefasoft.model.Proprietario;
import br.com.gefasoft.repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProprietarioService {
    private final ProprietarioRepository repository;

    public ProprietarioResponseDTO cadastrar(ProprietarioRequestDTO dto){
        Proprietario usuario= new Proprietario(null, dto.nome(), dto.senha(), dto.email(), new ArrayList<>());
        Proprietario userSalvo = repository.save(usuario);
        return toResponseDTO(userSalvo);
    }

    public List<ProprietarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(p -> new ProprietarioResponseDTO(p.getId(), p.getNome(), p.getEmail()))
                .toList();
    }

    public Proprietario buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Proprietário de id" + id + " inexistente"));
    }

    public void editarSenha(Long id, String senhaAtual, String novaSenha){
        Proprietario usuario = buscarPorId(id);

        if (!usuario.getSenha().equals(senhaAtual)) {
            throw new IllegalArgumentException("A senha atual está incorreta.");
        }
        usuario.setSenha(novaSenha);
        repository.save(usuario);
    }

    private ProprietarioResponseDTO toResponseDTO(Proprietario prop){
        return new ProprietarioResponseDTO(
                prop.getId(),
                prop.getNome(),
                prop.getEmail());
    }

}
