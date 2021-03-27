package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

    @Override
    protected void updateData(User newObj, User oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setName(oldObj.getName());
        newObj.setUserName(oldObj.getUserName());
        newObj.setProfiles(oldObj.getProfiles());
        newObj.setEmail(oldObj.getEmail());
    }

}
