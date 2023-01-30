package com.meqdad.personal.web.conatcts.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @UpdateTimestamp
    private Timestamp lastUpdatedDate;

    @CreationTimestamp
//    @Column(nullable = false)
    private Timestamp CreatedDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private List<Entry> entries = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "contact_label",
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

    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Timestamp getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        CreatedDate = createdDate;
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
        return Objects.equals(Id, contact.Id) && Objects.equals(firstName, contact.firstName) && Objects.equals(middleName, contact.middleName) && Objects.equals(lastName, contact.lastName) && Objects.equals(lastUpdatedDate, contact.lastUpdatedDate) && Objects.equals(CreatedDate, contact.CreatedDate) && Objects.equals(entries, contact.entries) && Objects.equals(labels, contact.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, middleName, lastName, lastUpdatedDate, CreatedDate, entries, labels);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", CreatedDate=" + CreatedDate +
                ", entries=" + entries +
                ", labels=" + labels +
                '}';
    }
}
