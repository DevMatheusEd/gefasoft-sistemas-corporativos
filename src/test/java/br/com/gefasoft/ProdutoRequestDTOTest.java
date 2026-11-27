package br.com.gefasoft;

import br.com.gefasoft.dto.ProdutoRequestDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import br.com.gefasoft.model.UnidadeMedida;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ProdutoRequestDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void deveValidarCamposObrigatoriosDoProduto() {
        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "",
                UnidadeMedida.KG,
                ""
        );

        Set var = validator.validate(dto);

        assertFalse(var.isEmpty());
    }
}
