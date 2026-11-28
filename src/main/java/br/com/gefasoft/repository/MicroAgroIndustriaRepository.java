package br.com.gefasoft.repository;

import br.com.gefasoft.model.MicroAgroIndustria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MicroAgroIndustriaRepository extends JpaRepository<MicroAgroIndustria, Long>{
    List<MicroAgroIndustria> findByNomeContainingIgnoreCase(String nome);
}
