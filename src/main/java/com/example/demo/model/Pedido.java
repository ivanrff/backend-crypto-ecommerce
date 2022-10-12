package com.example.demo.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="dataHora")
	private LocalDate datahora;

	@Column(name="quantidade")
	private Double quantidade;

	@Column(name="valor_total")
	private Double valorTotal;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_moeda")
	private Moeda moeda;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(LocalDate datahora, Double quantidade, Double valorTotal, Moeda moeda, Usuario usuario) {
		super();
		this.datahora = datahora;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.moeda = moeda;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDate datahora) {
		this.datahora = datahora;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
