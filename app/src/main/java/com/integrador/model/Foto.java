package com.integrador.model;

import java.io.Serializable;

public class Foto implements Serializable {

    private Banda banda;
    private Estudio estudio;
    private Long idFoto;
    private String path;

    public Foto() {
        super();

    }

    public Foto(Long idFoto, String path, Banda banda, Estudio estudio) {
        super();
        this.idFoto = idFoto;
        this.path = path;
        this.banda = banda;
        this.estudio = estudio;

    }


    public Long getId() {
        return idFoto;
    }


    public void setId(Long id) {
        this.idFoto = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

}
