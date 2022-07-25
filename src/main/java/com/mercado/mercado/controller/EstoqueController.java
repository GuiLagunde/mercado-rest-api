package com.mercado.mercado.controller;

import com.mercado.mercado.dto.EstoqueRequestDto;
import com.mercado.mercado.dto.EstoqueResponseDto;
import com.mercado.mercado.exception.ExceptionMessage;
import com.mercado.mercado.exception.MensagemJson;
import com.mercado.mercado.service.EstoqueService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EstoqueController {

    private final EstoqueService estoqueService;

    @ApiOperation(value = "salvar estoque")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity salvar (@RequestBody EstoqueRequestDto estoqueRequestDto ) {
        try {
            EstoqueResponseDto estoqueResponseDto = estoqueService.salvar(estoqueRequestDto);
            return new ResponseEntity(estoqueResponseDto, HttpStatus.CREATED);
        }catch (ExceptionMessage e ){
            return new ResponseEntity(new MensagemJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Busca todos  estoque cadastrados")
    @ApiResponse(code = 200, message = "OK", response = EstoqueResponseDto.class)
    @GetMapping(value = "/busca")
    public ResponseEntity buscaTodos() {
        try {
            List<EstoqueResponseDto> estoqueResponseDtos = estoqueService.buscaTodos();
            return new ResponseEntity(estoqueResponseDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new MensagemJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
