package it.step.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.step.entity.Utente;
import it.step.service.UtenteRestService;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/utentirest")
public class UtenteRestController {
	
	private final Logger LOG = LoggerFactory.getLogger(UtenteController.class);
	
	@Autowired
	private UtenteRestService restService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Utente>> getAll(){
		
		LOG.info("Method: getAll()");
		
		List<Utente> lst = restService.getAll();
		
		ResponseEntity<List<Utente>> responseEntity = (Objects.nonNull(lst) ? ResponseEntity.status(HttpStatus.OK).body(lst)
																			: ResponseEntity.status(HttpStatus.NO_CONTENT).build());
		return responseEntity;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> getById(@PathVariable("id") Integer id){
		LOG.info("Method: getById() - param Id : {}", id);
		
		Utente utente = restService.getUtenteById(id).orElse(null);
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(utente) ? ResponseEntity.status(HttpStatus.FOUND).body(utente)
																		: ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		return responseEntity;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> saveUser(@RequestBody Utente utente){
		LOG.info("Method: saveUser() - param utente : {}", utente);
		
		Utente userRes = restService.saveUtente(utente);
		
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(userRes) ? ResponseEntity.status(HttpStatus.CREATED).body(userRes) 
			   	 														  : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
		
		return responseEntity;
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> deleteById(@PathVariable("id") Integer id){
		LOG.info("Method: deleteById() - param Id : {}", id);
		
		Utente utente = restService.deleteUtente(id).orElse(null);
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(utente) ? ResponseEntity.status(HttpStatus.FOUND).body(utente)
																		 : ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		return responseEntity;
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> updateUtente(@PathVariable("id") Integer id, @RequestBody Utente utente){
		LOG.info("Method: updateUtente() - param Id : {}, utente: {}", id, utente);

		Utente userRes = restService.updateUtente(id, utente).orElse(null);
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(userRes) ? ResponseEntity.status(HttpStatus.FOUND).body(userRes)
																		  : ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		return responseEntity;
	}
}
