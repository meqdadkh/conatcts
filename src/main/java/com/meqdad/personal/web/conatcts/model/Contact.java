package com.meqdad.personal.web.conatcts.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private List<Entry> entries = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL} )
    @JoinTable(name = "label_Contact",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(Id, contact.Id) && Objects.equals(firstName, contact.firstName) && Objects.equals(middleName, contact.middleName) && Objects.equals(lastName, contact.lastName) && Objects.equals(entries, contact.entries) && Objects.equals(labels, contact.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, middleName, lastName, entries, labels);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", entries=" + entries +
                ", labels=" + labels +
                '}';
    }
}
