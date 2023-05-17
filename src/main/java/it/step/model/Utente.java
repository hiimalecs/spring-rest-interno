package it.step.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Utente {

	private Integer id;
	private String nome;
	private String email;
	private Double rate;
	private String data;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Utente(Integer id, String nome, String email, Double rate, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.rate = rate;
		this.data = data;
	}
	public Utente(String nome, String email, Double rate, String data) {
		super();
		this.nome = nome;
		this.email = email;
		this.rate = rate;
		this.data = data;
	}
	public Utente() {
		super();
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", email=" + email + ", rate=" + rate + ", data=" + data + "]";
	}
}