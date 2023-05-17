package it.step.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.step.model.Utente;
import it.step.service.UtenteService;

//@Controller
@RestController
@RequestMapping("/utenti")
public class UtenteController {
	
	//E io rifaccio le modifiche
	//Commento due

	@Autowired
	private UtenteService service;
	private final Logger LOG = LoggerFactory.getLogger(UtenteController.class);
	
//	@RequestMapping(method = RequestMethod.POST, 
//					consumes = MediaType.APPLICATION_JSON_VALUE,
//					produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) 
		//il produces indica che restituisco un oggetto in application json
		//l'ho tolto perché utilizzo il PostMapping che descrive implicitamente il metodo -> RestControllers
//	@ResponseBody la posso togliere perché ho una response entity
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Utente> regUtente(@RequestBody Utente utente) {

		LOG.info("---> regUtente(), JSON, Utente : {}" + utente);
		
		utente = service.saveUtente(utente);
		
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(utente) ? ResponseEntity.status(HttpStatus.CREATED).body(utente) 
																	   	 : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
		
		return responseEntity;
	}
	
//	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Utente>> getAll(){
		
		LOG.info("---> getAll(), JSON");
		
		List<Utente> lst = service.getAll();
		
		ResponseEntity<List<Utente>> responseList = (Objects.nonNull(lst) && lst.size()>0
													? ResponseEntity.ok(lst)
													: lst.size() == 0 
													? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
													: ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		return responseList;
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> getUtenteById(@PathVariable("id") Integer idUtente) {
		
		LOG.info("---> getUtenteById(), JSON, ID : {}", idUtente);
		Utente utente = service.getUtenteById(idUtente);
		
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(utente) ? ResponseEntity.status(HttpStatus.FOUND).body(utente) 
																		 : ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		return responseEntity;
	}
	
	//DELETE BY ID --- DELETEALL --- UPDATE
	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> deleteUtenteById(@PathVariable("id") Integer idUtente) {
		
		LOG.info("---> deleteUtenteById(), JSON, ID : {}", idUtente);
		Utente utente = service.deleteUtenteById(idUtente);
		
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(utente) ? ResponseEntity.status(HttpStatus.OK).body(utente)
																		 : ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		return responseEntity;
	}
	
//	@RequestMapping(value = "/deleteall", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	@DeleteMapping(value = "/deleteall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Utente>> deleteAllUtenti() {
		
		LOG.info("---> deleteAllUtenti(), JSON");
		List<Utente> lst = service.deleteAll();

		ResponseEntity<List<Utente>> responseList = (Objects.nonNull(lst) && lst.size()>0
													? ResponseEntity.ok(lst)
													: lst.size() == 0 
													? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
													: ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		return responseList;
	}

//	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
//	@ResponseBody
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> updateUtente(@RequestBody Utente utente) {

		LOG.info("---> updateUtente(), JSON, Utente : {}" + utente);
		utente = service.updateUtente(utente);
		
		ResponseEntity<Utente> responseEntity = (Objects.nonNull(utente) ? ResponseEntity.status(HttpStatus.OK).body(utente)
																		 : ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

		return responseEntity;
	}
	
//	@RequestMapping(method = RequestMethod.POST, 
//					consumes = MediaType.APPLICATION_JSON_VALUE,
//					produces = MediaType.APPLICATION_XML_VALUE)
//	@ResponseBody
//	public Utente regUtenteXML(@RequestBody Utente utente) {
//		
//		LOG.info("---> regUtenteXML(), XML, Utente : {}" + utente);
//		
//		utente.setData(LocalDate.now().toString());
//		utente.setId(new Random().nextInt(1000-1)+1);
//		
//		return utente;
//	}
}
