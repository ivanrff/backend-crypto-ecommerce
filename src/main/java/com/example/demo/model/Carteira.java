package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Carteira {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "qtd_paulocoin")
    private Double qtdPauloCoin;
    
    @Column(name = "total_reais")
    private Double totalReais;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_paulocoin")
    private PauloCoin pauloCoin;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQtdPauloCoin() {
		return qtdPauloCoin;
	}

	public void setQtdPauloCoin(Double qtdPauloCoin) {
		this.qtdPauloCoin = qtdPauloCoin;
	}

	public Double getTotalReais() {
		return totalReais;
	}

	public void setTotalReais(Double totalReais) {
		this.totalReais = totalReais;
	}

	public PauloCoin getPauloCoin() {
		return pauloCoin;
	}

	public void setPauloCoin(PauloCoin pauloCoin) {
		this.pauloCoin = pauloCoin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Carteira() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carteira(Double qtdPauloCoin, Double totalReais, PauloCoin pauloCoin, Usuario usuario) {
		super();
		this.qtdPauloCoin = qtdPauloCoin;
		this.totalReais = totalReais;
		this.pauloCoin = pauloCoin;
		this.usuario = usuario;
	}
    
    
}
