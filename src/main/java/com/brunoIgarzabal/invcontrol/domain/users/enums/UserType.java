package com.brunoIgarzabal.invcontrol.domain.users.enums;


public enum UserType {
    ADMIN(1, "ROLE_ADMIN"),
    SELLER(2, "ROLE_SELLER");

    private int cod;
    private String description;

    UserType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static UserType toEnum(Integer cod) {
        if (cod == null) return null;

        for (UserType x : UserType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + cod);
    }
}