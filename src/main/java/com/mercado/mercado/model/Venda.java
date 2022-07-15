package com.mercado.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Venda")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Cliente cliente;

    @Column(name = "Valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
}
