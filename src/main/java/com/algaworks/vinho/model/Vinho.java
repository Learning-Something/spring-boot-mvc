package com.algaworks.vinho.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Vinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String nome;

    @Getter
    @Setter
    @NotNull
    private TipoVinho tipo;

    @Getter
    @Setter
    @NumberFormat(pattern = "#,##0.00")
    @NotNull
    private BigDecimal valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vinho vinho = (Vinho) o;
        return Objects.equals(id, vinho.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
