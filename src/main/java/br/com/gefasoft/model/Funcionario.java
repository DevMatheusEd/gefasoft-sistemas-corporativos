package br.com.gefasoft.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String funcao;
}
