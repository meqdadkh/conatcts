package com.meqdad.personal.web.conatcts.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Entry {

    @Id
    @GeneratedValue
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntryType Type;

    @Column(nullable = false)
    private String content;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public EntryType getType() {
        return Type;
    }

    public void setType(EntryType type) {
        Type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(Id, entry.Id) && Type == entry.Type && Objects.equals(content, entry.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Type, content);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "Id=" + Id +
                ", Type=" + Type +
                ", content='" + content + '\'' +
                '}';
    }
}
