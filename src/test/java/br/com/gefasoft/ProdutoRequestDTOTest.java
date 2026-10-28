package br.com.gefasoft;

import br.com.gefasoft.dto.ProdutoRequestDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ProdutoRequestDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void deveValidarCamposObrigatoriosDoProduto() {
        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "",
                null,
                "",
                "",
                1L
        );

        Set var = validator.validate(dto);

        assertFalse(var.isEmpty());
    }
}
