package it.step.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.step.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{

}
