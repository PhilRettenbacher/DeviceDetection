package com.devicedetection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
public class EventTyp {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String beschreibung;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }



}