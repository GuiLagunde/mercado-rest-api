package com.mercado.mercado.repository;

import com.mercado.mercado.model.Estoque;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface EstoqueRepository extends PagingAndSortingRepository<Estoque, Long> {

    List<Estoque> findAll();
}
