package com.devicedetection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Geraet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String beschreibung;

    private Integer raumNr;

    private Date datumErstellung;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Integer getRaumNr() {
        return raumNr;
    }

    public void setRaumNr(Integer raumNr) {
        this.raumNr = raumNr;
    }

    public Date getDatumErstellung() {
        return datumErstellung;
    }

    public void setDatumErstellung(Date datumErstellung) {
        this.datumErstellung = datumErstellung;
    }


}