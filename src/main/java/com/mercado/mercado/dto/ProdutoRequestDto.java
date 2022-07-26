package com.mercado.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDto {

    private String nome;
    private BigDecimal preco;
    private LocalDateTime validade;
    private String fabricante;
}
