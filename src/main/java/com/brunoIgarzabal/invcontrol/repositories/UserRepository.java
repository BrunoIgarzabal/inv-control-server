package com.brunoIgarzabal.invcontrol.repositories;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    @Transactional(readOnly = true)
    User findByEmail(String email);

    @Transactional(readOnly = true)
    User findByUserName(String userName);
}
