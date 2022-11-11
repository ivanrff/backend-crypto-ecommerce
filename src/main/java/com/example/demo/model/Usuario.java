package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cartao_credito")
	private String cartaoCredito;

	@Column(name = "rua")
	private String rua;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "uf")
	private String uf;
	
	@Column(name = "numero_residencial")
	private String numeroResidencial;
	
	@Column(name = "senha")
	private String senha;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Pedido> pedido;
	
//	@OneToOne(mappedBy =  "usuario", fetch = FetchType.LAZY)
//	private Carteira carteira;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Usuario(String nome, String cpf, String email, String cartaoCredito, String rua, String cidade,
			String bairro, String uf, String numeroResidencial, String senha, Perfil perfil, List<Pedido> pedido) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cartaoCredito = cartaoCredito;
		this.rua = rua;
		this.cidade = cidade;
		this.bairro = bairro;
		this.uf = uf;
		this.numeroResidencial = numeroResidencial;
		this.senha = senha;
		this.perfil = perfil;
		this.pedido = pedido;
	}



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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCartaoCredito() {
		return cartaoCredito;
	}


	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getNumeroResidencial() {
		return numeroResidencial;
	}


	public void setNumeroResidencial(String numeroResidencial) {
		this.numeroResidencial = numeroResidencial;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public List<Pedido> getPedido() {
		return pedido;
	}


	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	
}
