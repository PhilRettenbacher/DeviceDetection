package com.devicedetection.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
public class GeraetEvent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Timestamp datum;

    private boolean eventTyp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "geraet_id", nullable = false)
    private Geraet geraet;

    public GeraetEvent()
    {

    }
    public GeraetEvent(Timestamp datum, Boolean eventTyp, Geraet geraet)
    {
        this.datum = datum;
        this.eventTyp = eventTyp;
        this.geraet = geraet;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }


    public Boolean getEventTyp() {
        return eventTyp;
    }

    public void setEventTyp(boolean eventTyp) {
        this.eventTyp = eventTyp;
    }

    public Geraet getGeraet()
    {
        return geraet;
    }
    public void setGeraet(Geraet geraet)
    {
        this.geraet = geraet;
    }

}


