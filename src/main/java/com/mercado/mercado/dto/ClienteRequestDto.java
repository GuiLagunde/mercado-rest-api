package com.mercado.mercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDto {

    private String nome;
    private String cpf;
    private LocalDateTime dataNascimento;
    private LocalDateTime dataCadastro;
    private String endereco;
}
