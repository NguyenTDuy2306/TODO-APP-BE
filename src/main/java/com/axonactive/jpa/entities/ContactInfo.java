package com.axonactive.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ContactInfo {
    private String phoneNumber;
    private String email;
    private String skype;
}
