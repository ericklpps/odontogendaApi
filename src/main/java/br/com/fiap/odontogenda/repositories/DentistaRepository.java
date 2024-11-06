package br.com.fiap.odontogenda.repositories;

import br.com.fiap.odontogenda.models.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, UUID> {
}