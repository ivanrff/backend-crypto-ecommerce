package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PauloCoin {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
    
    @NotBlank(message = "campo nome vazio")
    @Size(max = 80, message = "Preencha o nome!")
    @Column(name = "preco_real", nullable = false)
	private double precoReal;
    
    @Column(name = "data_att")
    @DateTimeFormat
	private LocalDate dataAtt;
    
    public PauloCoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PauloCoin(double precoReal, LocalDate dataAtt) {
    	super();
    	this.precoReal = precoReal;
    	this.dataAtt = dataAtt;
    }

	public double getPrecoReal() {
		return precoReal;
	}

	public void setPrecoReal(double precoReal) {
		this.precoReal = precoReal;
	}

	public LocalDate getDataAtt() {
		return dataAtt;
	}

	public void setDataAtt(LocalDate dataAtt) {
		this.dataAtt = dataAtt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
    
    
    
}
