package com.organizer.Organizer.Repositories;

import com.organizer.Organizer.Models.Task;
import com.organizer.Organizer.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select case when count(u) > 0 then true else false end from users u where lower(u.username) like lower(:username)", nativeQuery = true)
    boolean isSameUsernameExists(@Param("username") String username);

}
