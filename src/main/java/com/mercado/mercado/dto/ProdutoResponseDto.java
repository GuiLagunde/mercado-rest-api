package com.mercado.mercado.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ProdutoResponseDto {

    private Long id;
    private String nome;
    private BigDecimal preco;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate validade;
    private String fabricante;
}
