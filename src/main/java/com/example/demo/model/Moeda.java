package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Moeda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name = "nome")
	private String nome;
    
    @Column(name = "acronimo")
    private String acronimo;
    
    @Column(name = "icon_url")
	private String iconUrl;
    
    @Column(name = "preco_inst")
	private Double precoInst;
    
    @Column(name = "max_diario")
	private Double maxDiario;
    
    @Column(name = "min_diario")
	private Double minDiario;
    
    @Column(name = "open")
	private Double open;
    
    @Column(name = "close")
	private Double close;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedido;
    
	public Moeda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moeda(String nome, String acronimo, String iconUrl, Double precoInst, Double maxDiario, Double minDiario,
			Double open, Double close) {
		super();
		this.nome = nome;
		this.acronimo = acronimo;
		this.iconUrl = iconUrl;
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

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Double getPrecoInst() {
		return precoInst;
	}

	public void setPrecoInst(Double precoInst) {
		this.precoInst = precoInst;
	}

	public Double getMaxDiario() {
		return maxDiario;
	}

	public void setMaxDiario(Double maxDiario) {
		this.maxDiario = maxDiario;
	}

	public Double getMinDiario() {
		return minDiario;
	}

	public void setMinDiario(Double minDiario) {
		this.minDiario = minDiario;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Integer getId() {
		return id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
    
}
