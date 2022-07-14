package com.mercado.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Estoque")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @Column(name = "QuantidadeProdutos", nullable = false)
    private Integer quantidadeProdutos;
}
