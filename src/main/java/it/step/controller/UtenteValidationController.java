package it.step.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.step.entity.Utente;
import it.step.service.UtenteRestService;

@Controller
@RequestMapping("/validation")
public class UtenteValidationController {

	@Autowired
	private UtenteRestService service;

	private final Logger LOG = LoggerFactory.getLogger(UtenteValidationController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String goToRegPage(Model model) {

		LOG.info("---> goToRegPage() : Go To JSP Registration");
		model.addAttribute("user", new Utente());

		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") Utente ut, BindingResult result, Model model) {
		
		LOG.info("---> saveUser() : User - {}", ut);
		
		if(result.hasErrors()) {
			
			LOG.error(" --- Errore di Validazione! --- ");
			return "register";
		}
		
		Utente utenteRegOk = service.saveUtente(ut);
		model.addAttribute("user", utenteRegOk);
		
		return "esito";
	}
}
