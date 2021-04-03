package com.brunoIgarzabal.invcontrol.domain.providers.dto;

import com.brunoIgarzabal.invcontrol.domain.providers.Provider;

import java.io.Serializable;

public final class SimpleProviderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String companyName;
    private String fantasyName;


    public SimpleProviderDTO() {}

    public SimpleProviderDTO(Provider provider) {
        this.id = provider.getId();
        this.companyName = provider.getCompanyName();
        this.fantasyName = provider.getFantasyName();
    }

    public Provider toProvider() {
        return new Provider(this.id, this.companyName, this.fantasyName);
    }

    public Long getId() {
        return id;
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

}
