package br.com.gefasoft.service;

import br.com.gefasoft.dto.MicroAgroIndustriaRequestDTO;
import br.com.gefasoft.dto.MicroAgroIndustriaResponseDTO;
import br.com.gefasoft.model.MicroAgroIndustria;
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
        MicroAgroIndustria industria = new MicroAgroIndustria(null, dto.nome(), proprietario);
        MicroAgroIndustria salva = repository.save(industria);
        return toResponseDTO(salva);
    }

    public List<MicroAgroIndustriaResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(i -> new MicroAgroIndustriaResponseDTO(i.getId(), i.getNome(), i.getProprietario().getNome()))
                .toList();
    }

    // metodo que retorna o response
    public MicroAgroIndustriaResponseDTO buscarPorId(Long id) {
        MicroAgroIndustria industria = buscarEntidadePorId(id);
        return toResponseDTO(industria);
    }

    public MicroAgroIndustriaResponseDTO atualizar(Long id, MicroAgroIndustriaRequestDTO dto) {
        MicroAgroIndustria industria = buscarEntidadePorId(id);

        industria.setNome(dto.nome());

        MicroAgroIndustria atualizado = repository.save(industria);
        return toResponseDTO(atualizado);
    }

    public List<MicroAgroIndustriaResponseDTO> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(industria -> new MicroAgroIndustriaResponseDTO(
                        industria.getId(),
                        industria.getNome(),
                        industria.getProprietario().getNome()
                )).toList();
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Micro industria com id " + id + " inexistente");
        }
        repository.deleteById(id);
    }

    private MicroAgroIndustriaResponseDTO toResponseDTO(MicroAgroIndustria industria){
        return new MicroAgroIndustriaResponseDTO(
                industria.getId(),
                industria.getNome(),
                industria.getProprietario().getNome()
        );
    }

    // metodo para retornar o objeto
    private MicroAgroIndustria buscarEntidadePorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Micro industria com id " + id + " inexistente"));
    }
}
