package com.meqdad.personal.web.conatcts.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Label {

    @Id
    @GeneratedValue
    private Long labelId;

    @Column(nullable = false)
    private String name;

    @Column()
    private Colour colour = Colour.White;

    @ManyToMany(mappedBy = "labels")
    private List<Contact> contatcs = new ArrayList<>();

    public Label() {
        super();
    }

    public Label(Long id, String name, Colour colour) {
        this.labelId = id;
        this.name = name;
        this.colour = colour;
    }

    public Long getLabelId() {
        return labelId;
    }

    public String getName() {
        return name;
    }

    public Colour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Label{" +
                "getLabelId=" + labelId +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}


