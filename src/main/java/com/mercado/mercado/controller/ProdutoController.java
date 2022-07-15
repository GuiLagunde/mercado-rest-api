package com.mercado.mercado.controller;

import com.mercado.mercado.dto.ProdutoRequestDto;
import com.mercado.mercado.dto.ProdutoResponseDto;
import com.mercado.mercado.exception.ExceptionMessage;
import com.mercado.mercado.exception.MensagemJson;
import com.mercado.mercado.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

    private final ProdutoService produtoService;

    @ApiOperation(value = "salvar Produto")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity salvar (@RequestBody ProdutoRequestDto produtoRequestDto) {
        try {
            ProdutoResponseDto produtoResponseDto = produtoService.salvar(produtoRequestDto);
            return new ResponseEntity(produtoResponseDto, HttpStatus.CREATED);
        }catch (ExceptionMessage e ){
            return new ResponseEntity(new MensagemJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Busca todas as produto cadastradas")
    @ApiResponse(code = 200, message = "OK", response = ProdutoResponseDto.class)
    @GetMapping(value = "/busca")
    public ResponseEntity buscaTodos() {
        try {
            List<ProdutoResponseDto> produtoResponseDtos = produtoService.buscaTodos();
            return new ResponseEntity(produtoResponseDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new MensagemJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
