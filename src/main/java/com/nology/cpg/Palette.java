package com.nology.cpg;


import javax.persistence.*;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Palette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String createdBy;
    private Timestamp dateCreated;
    protected Color[] colours;
    @ElementCollection
    protected List<String> coloursHex;

    public Palette(){
    }
    public Palette(int id, String createdBy, List<String> coloursHex) {
        this.id = id;
        this.coloursHex = coloursHex;
        this.createdBy = createdBy;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Palette(Color[] colours) {
        this.colours = colours;
        this.dateCreated = new Timestamp(new Date().getTime());
    }
//
//    public Palette(String[] coloursHex) {
//        this.coloursHex = coloursHex;
//        this.dateCreated = new Timestamp(new Date().getTime());
//    }

    public int getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public List<String> getColoursHex() {
        return coloursHex;
    }
}
