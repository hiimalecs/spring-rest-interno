package it.step.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.step.entity.Utente;
import it.step.repo.UtenteRepository;
import it.step.service.UtenteRestService;

@Service
@Transactional
public class UtenteRestServiceImpl implements UtenteRestService {

	@Autowired
	private UtenteRepository repository;
	
	@Override
	public Utente saveUtente(Utente utente) {
		// TODO Auto-generated method stub
		Utente utente2 = repository.save(utente);
		
		return utente2;
	}

	@Override
	public Optional<Utente> getUtenteById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Utente> optRes = repository.findById(id);
		
		return optRes;
	}

	@Override
	public List<Utente> getAll() {
		// TODO Auto-generated method stub
		List<Utente> lst = repository.findAll();
		
		return lst;
	}

	@Override
	public Optional<Utente> deleteUtente(Integer id) {
		// TODO Auto-generated method stub
		Utente utente = repository.findById(id).get();
		repository.delete(utente);
		return Optional.of(utente);
	}

	@Override
	public Optional<Utente> updateUtente(Integer id, Utente utente) {
		// TODO Auto-generated method stub
		Utente user = repository.findById(id).orElse(null);
		user.setNome(utente.getNome());
		user.setEmail(utente.getEmail());
		user.setReddito(utente.getReddito());
		user.setNumFigli(utente.getNumFigli());
		return Optional.of(user);
	}

}
