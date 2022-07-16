package com.mercado.mercado.controller;

import com.mercado.mercado.dto.ClienteRequestDto;
import com.mercado.mercado.dto.ClienteResponseDto;
import com.mercado.mercado.exception.ExceptionMessage;
import com.mercado.mercado.exception.MensagemJson;
import com.mercado.mercado.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService clienteService;

    @ApiOperation(value = "salvar Cliente")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity salvar (@RequestBody ClienteRequestDto clienteRequestDto) {
        try {
            ClienteResponseDto clienteResponseDto = clienteService.salvar(clienteRequestDto);
            return new ResponseEntity(clienteResponseDto, HttpStatus.CREATED);
        }catch (ExceptionMessage e ){
            return new ResponseEntity(new MensagemJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Busca todas as Cliente cadastradas")
    @ApiResponse(code = 200, message = "OK", response = ClienteResponseDto.class)
    @GetMapping(value = "/busca")
    public ResponseEntity buscaTodos() {
        try {
            List<ClienteResponseDto> clienteResponseDtos = clienteService.buscaTodos();
            return new ResponseEntity(clienteResponseDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new MensagemJson(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
