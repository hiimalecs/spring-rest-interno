package it.step.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import it.step.model.Utente;

@Service
public class UtenteService {

	private List<Utente> lst = popolaLista();

	private List<Utente> popolaLista() {
		// TODO Auto-generated method stub
		
		lst = new LinkedList<Utente>();
		Utente utente = null;
		Faker faker = new Faker();
		
		for (int i = 0; i < 10; i++) {
			utente = new Utente();
			utente.setNome(faker.superhero().name());
			utente.setId(faker.number().numberBetween(1, 1000));
			utente.setEmail(faker.internet().emailAddress());
			utente.setRate(faker.number().randomDouble(2, 1, 100));
			utente.setData(LocalDate.ofInstant(faker.date().birthday().toInstant(), ZoneId.systemDefault()).toString());
			lst.add(utente);
		}
		return lst;
	}
	
	public List<Utente> getAll(){
		
		return this.lst;
	}
	
	public Utente saveUtente(Utente utente) {
		
		Faker faker = new Faker();
		
		utente.setId(faker.number().numberBetween(1, 1000));
		utente.setData(LocalDate.ofInstant(faker.date().birthday().toInstant(), ZoneId.systemDefault()).toString());
		this.lst.add(utente);
		
		return utente;
	}
	
	public Utente getUtenteById(Integer id) {
		
		Utente res = null;
		for (Utente utente : lst) {
			if(utente.getId().equals(id)) {
				res = utente;
			}
		}
		
		return res;
	}
	
	//DELETE BY ID --- DELETEALL --- UPDATE
	
	public Utente deleteUtenteById(Integer id) {

		Utente res = null;
		res = getUtenteById(id);
		lst.remove(res);
		
		return res;
	}
	
	public List<Utente> deleteAll(){
		
		List<Utente> res = new ArrayList<>();
		for (Utente ut : lst) {
			res.add(ut);
		}
		lst.removeAll(lst);
		
		return res;
	}
	
	public Utente updateUtente(Utente utente) {
		
		Utente res = null;
		
		Integer index = lst.indexOf(getUtenteById(utente.getId()));
		if(index != -1) {
			res = new Utente();
			//update massiccio
	//		res = lst.get(index);
	//		lst.set(index, utente);
			
			//alternativamente, update selettivo:
			res.setId(lst.get(index).getId());
			res.setNome(lst.get(index).getNome());
			res.setData(lst.get(index).getData());
			res.setEmail(lst.get(index).getEmail());
			res.setRate(lst.get(index).getRate());
			
			if(!Objects.isNull(utente.getEmail())) 	lst.get(index).setEmail(utente.getEmail());
			if(!Objects.isNull(utente.getData())) 	lst.get(index).setData(utente.getData());
			if(!Objects.isNull(utente.getNome())) 	lst.get(index).setNome(utente.getNome());
			if(!Objects.isNull(utente.getRate())) 	lst.get(index).setRate(utente.getRate());
		}
		
		return res;
	}
}