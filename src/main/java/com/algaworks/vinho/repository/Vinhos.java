package com.algaworks.vinho.repository;

import com.algaworks.vinho.model.Vinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vinhos extends JpaRepository<Vinho, Long> {
}
