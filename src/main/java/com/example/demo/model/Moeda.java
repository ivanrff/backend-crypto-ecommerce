package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moeda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
    
    @Column(name = "nome")
	private String nome;
    
    @Column(name = "acronimo")
    private String acronimo;
    
    @Column(name = "url")
	private String url;
    
    @Column(name = "preco_inst")
	private double precoInst;
    
    @Column(name = "max_diario")
	private double maxDiario;
    
    @Column(name = "min_diario")
	private double minDiario;
    
    @Column(name = "open")
	private double open;
    
    @Column(name = "close")
	private double close;

	public Moeda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moeda(String nome, String acronimo, String url, double precoInst, double maxDiario, double minDiario,
			double open, double close) {
		super();
		this.nome = nome;
		this.acronimo = acronimo;
		this.url = url;
		this.precoInst = precoInst;
		this.maxDiario = maxDiario;
		this.minDiario = minDiario;
		this.open = open;
		this.close = close;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrecoInst() {
		return precoInst;
	}

	public void setPrecoInst(double precoInst) {
		this.precoInst = precoInst;
	}

	public double getMaxDiario() {
		return maxDiario;
	}

	public void setMaxDiario(double maxDiario) {
		this.maxDiario = maxDiario;
	}

	public double getMinDiario() {
		return minDiario;
	}

	public void setMinDiario(double minDiario) {
		this.minDiario = minDiario;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public int getId() {
		return id;
	}
    
    
}
