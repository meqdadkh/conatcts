package com.meqdad.personal.web.conatcts.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String Line1;
    private String Line2;
    private String city;

    protected Address() {

    }

    public Address(String line1, String line2, String city) {
        Line1 = line1;
        Line2 = line2;
        this.city = city;
    }

}
