package com.mercado.mercado.repository;

import com.mercado.mercado.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

    List<Cliente> findAll();
}
