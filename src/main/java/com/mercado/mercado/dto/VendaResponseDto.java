package com.mercado.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponseDto {

    private Long id;
    private ProdutoResponseDto produto;
    private ClienteResponseDto cliente;
    private BigDecimal valor;
}
