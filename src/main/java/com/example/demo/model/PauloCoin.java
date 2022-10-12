package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PauloCoin {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name = "preco_real", nullable = false)
	private Double precoReal;
    
    @Column(name = "data_att")
    @DateTimeFormat
	private LocalDate dataAtt;
    
    public PauloCoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PauloCoin(Double precoReal, LocalDate dataAtt) {
    	super();
    	this.precoReal = precoReal;
    	this.dataAtt = dataAtt;
    }

	public Double getPrecoReal() {
		return precoReal;
	}

	public void setPrecoReal(Double precoReal) {
		this.precoReal = precoReal;
	}

	public LocalDate getDataAtt() {
		return dataAtt;
	}

	public void setDataAtt(LocalDate dataAtt) {
		this.dataAtt = dataAtt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
    
    
    
}
