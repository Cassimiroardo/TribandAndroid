package com.integrador.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Reserva implements Serializable {

    private Estudio estudio;
    private Banda banda;
    private Date dataReserva;
    private Time horarioFinal;
    private Time horarioInicio;
    private Long idReserva;
    private Double preco;

    public Reserva() {
        super();

    }

    public Reserva(Estudio agenda, Banda banda, Date dataReserva, Time horarioFinal, Time horarioInicio,
                   Long idReserva) {

        super();

        this.estudio = agenda;
        this.banda = banda;
        this.dataReserva = dataReserva;
        this.horarioFinal = horarioFinal;
        this.horarioInicio = horarioInicio;
        this.idReserva = idReserva;
    }

    //GETS E SETS

    public Long getId() {
        return this.idReserva;
    }

    public void setId(Long id) {
        this.idReserva = id;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Banda getBanda() {
        return banda;
    }
    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    public Estudio getEstudio() {
        return estudio;
    }
    public void setEstudio(Estudio agenda) {
        this.estudio = agenda;
    }


}
