package com.mercado.mercado.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponseDto {

    private Long id;
    private String nome;
    private BigDecimal preco;

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime validade;
    private String fabricante;
}
