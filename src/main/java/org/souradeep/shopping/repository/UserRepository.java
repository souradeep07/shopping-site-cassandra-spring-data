package org.souradeep.shopping.repository;

import java.util.UUID;

import org.souradeep.shopping.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

}
