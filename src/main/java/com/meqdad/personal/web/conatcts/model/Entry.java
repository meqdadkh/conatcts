package com.meqdad.personal.web.conatcts.model;

import javax.persistence.*;

@Entity
public class Entry {

    @Id
    @GeneratedValue
    private Long entryId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntryType Type;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Entry() {
        super();
    }

    public Entry(Long entryId, EntryType type, String content) {
        this.entryId = entryId;
        Type = type;
        this.content = content;
    }

    public Long getEntryId() {
        return entryId;
    }

    public EntryType getType() {
        return Type;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryId=" + entryId +
                ", Type=" + Type +
                ", content='" + content + '\'' +
                '}';
    }
}
