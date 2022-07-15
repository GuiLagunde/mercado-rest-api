package com.mercado.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDto {

    private String nome;
    private BigDecimal preco;
    private LocalDate validade;
    private String fabricante;
}
