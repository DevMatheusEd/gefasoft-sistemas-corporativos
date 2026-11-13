package br.com.gefasoft.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_industria")
public class MicroAgroindustria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String nome;
    @ManyToOne(optional = false)
    @JoinColumn(name = "proprietario_id", nullable = false)   // tem um dono
    private Proprietario proprietario;
}
