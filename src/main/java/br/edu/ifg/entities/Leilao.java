package br.edu.ifg.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "LEILAO")
public class Leilao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long idLeilao;
	private String item;
	private Double lanceMinimo;
	private Status status;
	private LocalDate dataExpiracao;
	
	
	
	public Leilao() {
		
	}
	
	
	public Leilao(String item, Double lanceMinimo, Status status, LocalDate dataExpiracao) {
		this.item = item;
		this.lanceMinimo = lanceMinimo;
		this.status = status;
		this.dataExpiracao = dataExpiracao;
	}
	
	
	
	public Leilao(long idLeilao, String item, Double lanceMinimo, Status status, LocalDate dataExpiracao) {
		super();
		this.idLeilao = idLeilao;
		this.item = item;
		this.lanceMinimo = lanceMinimo;
		this.status = status;
		this.dataExpiracao = dataExpiracao;
	}


	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getLanceMinimo() {
		return lanceMinimo;
	}
	public void setLanceMinimo(Double lanceMinimo) {
		this.lanceMinimo = lanceMinimo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDate getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(LocalDate dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public long getIdLeilao() {
		return idLeilao;
	}
	
	
	
	
}
