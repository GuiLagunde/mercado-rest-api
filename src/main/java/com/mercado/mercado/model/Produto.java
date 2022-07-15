package com.mercado.mercado.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Produto")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "Preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @CreationTimestamp
    @Column(name = "Validade", updatable = false, insertable = true, nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate validade;

    @Column(name = "Fabricante", nullable = false, length = 30)
    private String fabricante;

}
