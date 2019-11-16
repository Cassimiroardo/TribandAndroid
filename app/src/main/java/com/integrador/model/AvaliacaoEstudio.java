package com.integrador.model;

import java.io.Serializable;
import java.sql.Date;

public class AvaliacaoEstudio implements Serializable {

    private Integer atendimento;
    private Integer compromissoHorario;
    private Date dataAvaliacaoEstudio;
    private Estudio estudio;
    private Long idAvaliacaoEstudio;
    private Integer limpeza;
    private Integer qualidadeEquipamento;


    public AvaliacaoEstudio() {
        super();

    }




    public AvaliacaoEstudio(Integer atendimento, Integer compromissoHorario, Date dataAvaliacaoEstudio, Estudio estudio,
                            Long idAvaliacaoEstudio, Integer limpeza, Integer qualidadeEquipamento) {
        super();
        this.atendimento = atendimento;
        this.compromissoHorario = compromissoHorario;
        this.dataAvaliacaoEstudio = dataAvaliacaoEstudio;
        this.estudio = estudio;
        this.idAvaliacaoEstudio = idAvaliacaoEstudio;
        this.limpeza = limpeza;
        this.qualidadeEquipamento = qualidadeEquipamento;

    }




    // GETS E SETS

    public Long getId() {
        return idAvaliacaoEstudio;
    }

    public void setId(Long idAvEstudio) {
        this.idAvaliacaoEstudio = idAvEstudio;
    }

    public Integer getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(Integer limpeza) {
        this.limpeza = limpeza;
    }

    public Integer getCompromissoHorario() {
        return compromissoHorario;
    }


    public void setCompromissoHorario(Integer compromissoHorario) {
        this.compromissoHorario = compromissoHorario;
    }


    public Integer getQualidadeEquipamento() {
        return qualidadeEquipamento;
    }


    public void setQualidadeEquipamento(Integer qualidadeEquipamento) {
        this.qualidadeEquipamento = qualidadeEquipamento;
    }


    public Integer getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Integer atendimento) {
        this.atendimento = atendimento;
    }


    public Date getDataAvaliacaoEstudio() {
        return dataAvaliacaoEstudio;
    }

    public void setDataAvaliacaoEstudio(Date dataAvaliacaoEstudio) {
        this.dataAvaliacaoEstudio = dataAvaliacaoEstudio;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }


    // OUTROS METODOS

}