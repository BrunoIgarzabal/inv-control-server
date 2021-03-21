package com.brunoIgarzabal.invcontrol.domain.contact;

import com.brunoIgarzabal.invcontrol.domain.Base;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_contact")
public final class Contact extends Base<Contact> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String phone;
    private String cellPhone;
    private String email;

    private Contact() {}

    public Contact(Long id, String phone, String cellPhone, String email) {
        this.id = id;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
