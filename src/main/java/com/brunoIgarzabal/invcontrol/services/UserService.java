package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import com.brunoIgarzabal.invcontrol.security.UserSpringSecurity;
import com.brunoIgarzabal.invcontrol.services.exceptions.AuthorizationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

    @Override
    public User find(Long id) {
        UserSpringSecurity user = UserService.authenticated();
        if (user == null || !user.hasRole(UserType.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }
        return super.find(id);
    }

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void updateData(User newObj, User oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setName(oldObj.getName());
        newObj.setUserName(oldObj.getUserName());
        newObj.setProfiles(oldObj.getProfiles());
        newObj.setEmail(oldObj.getEmail());
    }

}
