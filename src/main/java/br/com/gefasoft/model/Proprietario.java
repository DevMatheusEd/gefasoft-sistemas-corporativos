package br.com.gefasoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_proprietario")
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "proprietario")
    private List<Industria> industrias = new ArrayList<>();

    @OneToMany(mappedBy = "proprietario")
    private List<Produto> produtos = new ArrayList<>();
}
