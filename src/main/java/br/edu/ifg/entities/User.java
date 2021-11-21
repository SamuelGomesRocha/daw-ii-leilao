package br.edu.ifg.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idUser;
	@Column(unique = true, nullable=false)
	@NotNull
	@NotEmpty(message = "O CPF deve ser informado!")
	private String cpf;
	@NotNull
	@NotEmpty(message = "O nome deve ser informado!")
	private String nome;
	private String email;
	private String telefone;
	@Column(unique = true)
	@NotNull
	@NotEmpty(message = "O user name deve ser informado!")
	private String userName;
	@NotEmpty(message = "O password deve ser informado!")
	private String password;
	//@Pattern(regexp = "^31\\/(0[13578]|1[02])) \\/\\d{4}|30\\/(0[13-9]|1[0-2])|((0[1-9]|[12]\\d)\\/(0[1-9]|1[0-2])$", message = "A data deve obedecer o padrão de data (yyyy-mm-dd)!")
	private LocalDate dataNasc;
	private Acesso acesso;
	
	
	public User() {
		
	}
	
	
	
	public User(String cpf, String nome, String email, String telefone, String userName, String password) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.userName = userName;
		this.password = password;
	}

	
	public User(String cpf, String nome, String email, String telefone, String userName, String password,
			Acesso acesso) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.userName = userName;
		this.password = password;
		this.acesso = acesso;
	}

	
	public User(Long idUser, String cpf, String nome, String email, String telefone, String userName, String password,
			Acesso acesso) {
		super();
		this.idUser = idUser;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.userName = userName;
		this.password = password;
		this.acesso = acesso;
	}

	

	public User(Long idUser, String cpf, String nome, String email, String telefone, String userName, String password,
			LocalDate dataNasc, Acesso acesso) {
		super();
		this.idUser = idUser;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.userName = userName;
		this.password = password;
		this.dataNasc = dataNasc;
		this.acesso = acesso;
	}
	

	public User(String cpf, String nome, String email, String telefone, String userName, String password,
			LocalDate dataNasc, Acesso acesso) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.userName = userName;
		this.password = password;
		this.dataNasc = dataNasc;
		this.acesso = acesso;
	}



	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
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


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Acesso getAcesso() {
		return acesso;
	}


	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}


	public Long getIdUser() {
		return idUser;
	}



	public LocalDate getDataNasc() {
		return dataNasc;
	}



	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	
	
	
}
