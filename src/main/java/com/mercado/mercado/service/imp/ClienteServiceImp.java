package com.mercado.mercado.service.imp;

import com.mercado.mercado.dto.ClienteRequestDto;
import com.mercado.mercado.dto.ClienteResponseDto;
import com.mercado.mercado.exception.ExceptionMessage;
import com.mercado.mercado.model.Cliente;
import com.mercado.mercado.repository.ClienteRepository;
import com.mercado.mercado.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    @Override
    public ClienteResponseDto salvar(ClienteRequestDto clienteRequestDto) {
        try {
            Cliente cliente = converteClienteRequestDtoParaCliente(clienteRequestDto, null);
            Cliente save = clienteRepository.save(cliente);
            ClienteResponseDto clienteResponseDto = converteClienteParaClienteResponseDto(save);
            return clienteResponseDto;
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponseDto> buscaTodos() {
        try {
            List<Cliente> clientes = clienteRepository.findAll();
            List<ClienteResponseDto> clienteResponseDtos = clientes.stream()
                    .map(cliente -> converteClienteParaClienteResponseDto(cliente))
                    .collect(Collectors.toList());

            return clienteResponseDtos;
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro buscar Cliente");
        }
    }

    private Cliente converteClienteRequestDtoParaCliente(ClienteRequestDto clienteRequestDto, Long clienteId) {
        try {
            return Cliente.builder()
                    .id(clienteId)
                    .nome(clienteRequestDto.getNome())
                    .cpf(clienteRequestDto.getCpf())
                    .dataNascimento(clienteRequestDto.getDataNascimento())
                    .dataCadastro(clienteRequestDto.getDataCadastro())
                    .endereco(clienteRequestDto.getEndereco())
                    .build();
        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro ao converter Cliente ");
        }
    }
    public ClienteResponseDto converteClienteParaClienteResponseDto(Cliente cliente) {
        try {
            return ClienteResponseDto.builder()
                    .id(cliente.getId())
                    .nome(cliente.getNome())
                    .cpf(cliente.getCpf())
                    .dataNascimento(cliente.getDataNascimento())
                    .dataCadastro(cliente.getDataCadastro())
                    .endereco(cliente.getEndereco())
                    .build();

        } catch (ExceptionMessage e) {
            throw new ExceptionMessage("Erro ao converter Cliente ");
        }

    }
}
