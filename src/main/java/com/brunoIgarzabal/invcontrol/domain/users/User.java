package com.brunoIgarzabal.invcontrol.domain.users;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_users")
public final class User extends Base<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String userName;

    private Integer userType;

    private String password;

    public User() {}

    public User(Long id, String email, String userName, String name, UserType userType, String password) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.name = name;
        this.userType = userType.getCod();
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return UserType.toEnum(userType);
    }

    public void setUserType(UserType userType) {
        this.userType = userType.getCod();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
