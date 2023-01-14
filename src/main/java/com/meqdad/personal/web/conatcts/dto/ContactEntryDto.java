package com.meqdad.personal.web.conatcts.dto;

import com.meqdad.personal.web.conatcts.model.EntryType;

public class ContactEntryDto {

    private String firstName;
    private String lastName;
    private EntryType entrytype;
    private String content;

    public ContactEntryDto(String firstName, String lastName, EntryType entrytype, String content) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.entrytype = entrytype;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ContacEntryDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", entrytype=" + entrytype +
                ", content='" + content + '\'' +
                '}';
    }
}
