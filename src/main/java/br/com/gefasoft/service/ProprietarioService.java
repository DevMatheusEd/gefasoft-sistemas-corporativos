package br.com.gefasoft.service;

import br.com.gefasoft.dto.ProprietarioRequestDTO;
import br.com.gefasoft.dto.ProprietarioResponseDTO;

import br.com.gefasoft.model.Proprietario;
import br.com.gefasoft.repository.ProprietarioRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ProprietarioService {
    private final ProprietarioRepository repository;

    public ProprietarioService(ProprietarioRepository repository) {
        this.repository = repository;
    }

    public ProprietarioResponseDTO cadastrar(ProprietarioRequestDTO dto){
        Proprietario usuario= new Proprietario(null, dto.nome(), dto.senha(), new ArrayList<>());
        Proprietario userSalvo = repository.save(usuario);
        return toResponseDTO(userSalvo);
    }

    private ProprietarioResponseDTO toResponseDTO(Proprietario prop){
        return new ProprietarioResponseDTO(
                prop.getId(),
                prop.getNome());
    }

}
