package com.mercado.mercado.service;

import com.mercado.mercado.dto.EstoqueRequestDto;
import com.mercado.mercado.dto.EstoqueResponseDto;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface EstoqueService {

    @Transactional
    EstoqueResponseDto salvar(EstoqueRequestDto estoqueRequestDto);

    @Transactional(readOnly = true)
    List<EstoqueResponseDto> buscaTodos();
}
