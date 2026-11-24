package br.com.gefasoft.service;

import br.com.gefasoft.dto.MicroAgroIndustriaRequestDTO;
import br.com.gefasoft.dto.MicroAgroIndustriaResponseDTO;
import br.com.gefasoft.model.MicroAgroindustria;
import br.com.gefasoft.model.Proprietario;
import br.com.gefasoft.repository.MicroAgroIndustriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MicroAgroIndustriaService {
    private final MicroAgroIndustriaRepository repository;
    private final ProprietarioService proprietarioService;

    public MicroAgroIndustriaResponseDTO cadastrar(MicroAgroIndustriaRequestDTO dto){
        Proprietario proprietario = proprietarioService.buscarPorId(dto.proprietarioId());
        MicroAgroindustria industria = new MicroAgroindustria(null, dto.nome(), proprietario);
        MicroAgroindustria salva = repository.save(industria);
        return toResponseDTO(salva);
    }

    public List<MicroAgroIndustriaResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(i -> new MicroAgroIndustriaResponseDTO(i.getId(), i.getNome(), i.getProprietario().getNome()))
                .toList();
    }

    public MicroAgroindustria buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Micro industria com id" + id + "inexistente"));
    }

    public MicroAgroIndustriaResponseDTO atualizar(Long id, MicroAgroIndustriaRequestDTO dto) {
        MicroAgroindustria industria = buscarPorId(id);

        industria.setNome(dto.nome());

        MicroAgroindustria atualizado = repository.save(industria);
        return toResponseDTO(atualizado);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Micro industria com id " + id + " inexistente");
        }
        repository.deleteById(id);
    }

    private MicroAgroIndustriaResponseDTO toResponseDTO(MicroAgroindustria industria){
        return new MicroAgroIndustriaResponseDTO(
                industria.getId(),
                industria.getNome(),
                industria.getProprietario().getNome()
        );
    }
}
