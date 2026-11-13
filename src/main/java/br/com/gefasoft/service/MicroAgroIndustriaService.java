package br.com.gefasoft.service;

import br.com.gefasoft.dto.MicroAgroIndustriaRequestDTO;
import br.com.gefasoft.dto.MicroAgroIndustriaResponseDTO;
import br.com.gefasoft.model.MicroAgroindustria;
import br.com.gefasoft.model.Proprietario;
import br.com.gefasoft.repository.MicroAgroIndustriaRepository;
import br.com.gefasoft.repository.ProprietarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MicroAgroIndustriaService {
    private final MicroAgroIndustriaRepository repository;
    private final ProprietarioRepository proprietarioRepository;

    public MicroAgroIndustriaResponseDTO cadastrar(MicroAgroIndustriaRequestDTO dto){
        Proprietario proprietario = proprietarioRepository.findById(dto.proprietarioId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Proprietário não encontrado com id: " + dto.proprietarioId()));
        MicroAgroindustria industria = new MicroAgroindustria(null, dto.nome(), proprietario);
        MicroAgroindustria salva = repository.save(industria);
        return toResponseDTO(salva);
    }

    private MicroAgroIndustriaResponseDTO toResponseDTO(MicroAgroindustria industria){
        return new MicroAgroIndustriaResponseDTO(
                industria.getId(),
                industria.getNome(),
                industria.getProprietario().getNome()
        );
    }
}
