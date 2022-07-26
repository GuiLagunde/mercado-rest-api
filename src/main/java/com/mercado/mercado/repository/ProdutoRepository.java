package com.mercado.mercado.repository;

import com.mercado.mercado.model.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

        List<Produto> findAll();

}
