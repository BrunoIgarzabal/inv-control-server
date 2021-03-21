package com.brunoIgarzabal.invcontrol.domain.contacts.dto;

import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;

import java.io.Serializable;

public final class ContactDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String phone;
    private String cellPhone;
    private String email;

    public ContactDTO() {}

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.phone = contact.getPhone();
        this.cellPhone = contact.getCellPhone();
        this.email = contact.getEmail();
    }
}
