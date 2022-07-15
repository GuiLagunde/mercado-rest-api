package com.mercado.mercado.service.imp;


import com.mercado.mercado.dto.ProdutoRequestDto;
import com.mercado.mercado.dto.ProdutoResponseDto;
import com.mercado.mercado.exception.ExceptionMessage;
import com.mercado.mercado.model.Produto;
import com.mercado.mercado.repository.ProdutoRepository;
import com.mercado.mercado.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoServiceImp implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Transactional
    @Override
    public ProdutoResponseDto salvar(ProdutoRequestDto produtoRequestDto) {
        try {
            Produto produto = converteProdutoRequestDtoParaProduto(produtoRequestDto, null);
            Produto save = produtoRepository.save(produto);
            ProdutoResponseDto produtoResponseDto = converteProdutoParaProdutoResponseDto(save);
            return produtoResponseDto;
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponseDto> buscaTodos() {
        try {
            List<Produto> produtos = produtoRepository.findAll();
            List<ProdutoResponseDto> produtoResponseDtos = produtos.stream()
                    .map(produto -> converteProdutoParaProdutoResponseDto(produto))
                    .collect(Collectors.toList());

            return produtoResponseDtos;
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro buscar produto");
        }
    }

    private Produto converteProdutoRequestDtoParaProduto(ProdutoRequestDto produtoRequestDto, Long produtoId) {
        try {
            return Produto.builder()
                    .id(produtoId)
                    .nome(produtoRequestDto.getNome())
                    .preco(produtoRequestDto.getPreco())
                    .validade(produtoRequestDto.getValidade())
                    .fabricante(produtoRequestDto.getFabricante())
                    .build();
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro ao converter Produto ");
        }
    }

    public ProdutoResponseDto converteProdutoParaProdutoResponseDto(Produto produto) {
        try {
            return ProdutoResponseDto.builder()
                    .id(produto.getId())
                    .nome(produto.getNome())
                    .preco(produto.getPreco())
                    .validade(produto.getValidade())
                    .fabricante(produto.getFabricante())
                    .build();

        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro ao converter Produto ");
        }

    }
}
