package com.meqdad.personal.web.conatcts.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Label {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column()
    private Colour colour = Colour.White;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "labels")
    private List<Contact> contatcs = new ArrayList<>();

    public Label() {
        super();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public List<Contact> getContatcs() {
        return contatcs;
    }

    public void setContatcs(List<Contact> contatcs) {
        this.contatcs = contatcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(Id, label.Id) && Objects.equals(name, label.name) && colour == label.colour && Objects.equals(contatcs, label.contatcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, colour, contatcs);
    }

    @Override
    public String toString() {
        return "Label{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", colour=" + colour +
                '}';
    }
}


