package com.mercado.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueResponseDto {

    private Long id;
    private ProdutoResponseDto produto;
    private Integer quantidadeProdutos;
}
