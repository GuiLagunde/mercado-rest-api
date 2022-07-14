package com.mercado.mercado.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cliente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false,length = 30)
    private String nome;

    @Column(name = "CPF",nullable = false, length = 16)
    private String cpf;

    @UpdateTimestamp
    @Column(name = "DataNascimento", updatable = true, insertable = false, nullable = true)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime dataNascimento;

    @CreationTimestamp
    @Column(name = "DataCadastro", updatable = false, insertable = true, nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime dataCadastro;

    @Column(name = "Endereco",nullable = false)
    private String endereco;
}
