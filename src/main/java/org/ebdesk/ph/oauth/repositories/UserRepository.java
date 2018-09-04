package org.ebdesk.ph.oauth.repositories;

import org.ebdesk.ph.oauth.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserByUsername(String username);
}
