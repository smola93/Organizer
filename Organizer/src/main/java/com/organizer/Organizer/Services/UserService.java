package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.User;
import com.organizer.Organizer.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public boolean isUsernameExists(String username) {
        return repository.isSameUsernameExists(username);
    }
}
