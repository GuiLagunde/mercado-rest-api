package com.mercado.mercado.service.imp;

import com.mercado.mercado.dto.*;
import com.mercado.mercado.exception.ExceptionMessage;
import com.mercado.mercado.model.Cliente;
import com.mercado.mercado.model.Estoque;
import com.mercado.mercado.model.Produto;
import com.mercado.mercado.repository.EstoqueRepository;
import com.mercado.mercado.repository.ProdutoRepository;
import com.mercado.mercado.service.EstoqueService;
import com.mercado.mercado.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EstoqueServiceImp implements EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoService produtoService;
    private final ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public EstoqueResponseDto salvar(EstoqueRequestDto estoqueRequestDto) {
        try {
            Estoque estoque = converteEstoqueRequestDtoParaEstoque(estoqueRequestDto, null);
            Estoque save = estoqueRepository.save(estoque);
            EstoqueResponseDto estoqueResponseDto = converteEstoqueParaEstoqueResponseDto(save);
            return estoqueResponseDto;
        }catch (ExceptionMessage e){
            throw new ExceptionMessage(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstoqueResponseDto> buscaTodos() {
        try {
            List<Estoque> estoques = estoqueRepository.findAll();
            List<EstoqueResponseDto> estoqueResponseDtos = estoques.stream()
                    .map(estoque -> converteEstoqueParaEstoqueResponseDto(estoque))
                    .collect(Collectors.toList());

            return estoqueResponseDtos;
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro ao buscar Estoque");
        }
    }

    private Estoque converteEstoqueRequestDtoParaEstoque(EstoqueRequestDto estoqueRequestDto, Long estoqueId) {

        Produto produto = produtoRepository.findById(estoqueRequestDto.getProdutoId())
                .orElseThrow(() -> new ExceptionMessage("produto não encontrado"));

        try {
            return Estoque.builder()
                    .id(estoqueId)
                    .produto(produto)
                    .quantidadeProdutos(estoqueRequestDto.getQuantidadeProdutos())
                    .build();
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro ao converter Estoque ");
        }
    }

    private EstoqueResponseDto converteEstoqueParaEstoqueResponseDto(Estoque estoque){

        try {
            ProdutoResponseDto produtoResponseDto = produtoService.converteProdutoParaProdutoResponseDto(estoque.getProduto());

            return EstoqueResponseDto.builder()
                    .id(estoque.getId())
                    .quantidadeProdutos(estoque.getQuantidadeProdutos())
                    .produto(produtoResponseDto)
                    .build();
        } catch (ExceptionMessage e) {

            throw new ExceptionMessage("Erro ao converter Estoque");
        }

    }
}
