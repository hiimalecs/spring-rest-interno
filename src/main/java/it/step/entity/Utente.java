package it.step.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@Table(name="utenti")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
@JsonPropertyOrder(value = {"id-utente", "nome", "reddito", "email", "num_figli"})
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonProperty(value = "id-utente")
	private Integer idUtente;

//	@NotEmpty(message = "La mail è un campo obbligatorio")
	@NotEmpty
	@Email
	private String email;

	@NotEmpty
//	@NotEmpty(message = "Il nome è un campo obbligatorio")
//	@Size(min = 5, max = 15, message = "Il numero di caratteri del nome deve essere compreso tra {2} e {1}")
	@Size(min = 5, max = 15)
	private String nome;

	@Column(name="num_figli")
	@JsonProperty(value = "num_figli")
	@Min(value = 0)
	@Max(value = 4)
	private Integer numFigli;

	@DecimalMin(value = "8000")
	@DecimalMax(value = "75000")
	private Double reddito;

	public Utente() {
	}

	public Integer getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumFigli() {
		return this.numFigli;
	}

	public void setNumFigli(Integer numFigli) {
		this.numFigli = numFigli;
	}

	public Double getReddito() {
		return this.reddito;
	}

	public void setReddito(Double reddito) {
		this.reddito = reddito;
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", email=" + email + ", nome=" + nome + ", numFigli=" + numFigli
				+ ", reddito=" + reddito + "]";
	}
}