package com.mercado.mercado.service;

import com.mercado.mercado.dto.ProdutoRequestDto;
import com.mercado.mercado.dto.ProdutoResponseDto;
import com.mercado.mercado.model.Produto;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ProdutoService {

    @Transactional
    ProdutoResponseDto salvar(ProdutoRequestDto produtoRequestDto);

    @Transactional(readOnly = true)
    List<ProdutoResponseDto> buscaTodos();

    ProdutoResponseDto converteProdutoParaProdutoResponseDto(Produto produto);
}
