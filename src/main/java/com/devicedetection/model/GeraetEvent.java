package com.devicedetection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
public class GeraetEvent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Date datum;

    private Integer geraetesignatur_id;

    private Integer eventTyp_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }


    public Integer getGeraetesignatur_id() {
        return geraetesignatur_id;
    }

    public void setGeraetesignatur_id(Integer geraetesignatur_id) {
        this.geraetesignatur_id = geraetesignatur_id;
    }


    public Integer getEventTyp_id() {
        return eventTyp_id;
    }

    public void setEventTyp_id(Integer eventTyp_id) {
        this.eventTyp_id = eventTyp_id;
    }

}


