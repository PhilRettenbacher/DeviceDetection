package com.devicedetection.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.sql.Date;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Geraet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String beschreibung;

    private Integer raumNr;

    private Integer verbrauch;

    @OneToMany(mappedBy = "geraet", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<GeraetEvent> events;


    public Geraet()
    {

    }
    public Geraet(String name, String beschreibung, Integer raumNr, Integer verbrauch)
    {
        this.name = name;
        this.beschreibung = beschreibung;
        this.raumNr = raumNr;
        this.verbrauch = verbrauch;
    }

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

    public Integer getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(Integer verbrauch) {
        this.verbrauch = verbrauch;
    }


}