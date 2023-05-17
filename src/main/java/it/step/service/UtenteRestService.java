package it.step.service;

import java.util.List;
import java.util.Optional;

import it.step.entity.Utente;

public interface UtenteRestService {

	public Utente saveUtente(Utente utente);
	
	public Optional<Utente> getUtenteById(Integer id);
	
	public List<Utente> getAll();
	
	public Optional<Utente> deleteUtente(Integer id);
	
	public Optional<Utente> updateUtente(Integer id, Utente utente);
}
