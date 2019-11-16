package com.integrador.Triband;

import java.io.Serializable;

public class Filme implements Serializable {
	private Integer id;
	private String titulo;
	private Integer ano;
	private String genero;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


    @Override
    public String toString() {
        return this.titulo;
    }
}