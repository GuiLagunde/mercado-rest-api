package com.mercado.mercado.service;

import com.mercado.mercado.dto.ClienteRequestDto;
import com.mercado.mercado.dto.ClienteResponseDto;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ClienteService {

    @Transactional
    ClienteResponseDto salvar(ClienteRequestDto clienteRequestDto);

    @Transactional(readOnly = true)
    List<ClienteResponseDto> buscaTodos();
}
