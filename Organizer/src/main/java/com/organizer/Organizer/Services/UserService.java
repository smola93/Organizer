package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.User;
import com.organizer.Organizer.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean isUsernameExists(String username) {
        return repository.isSameUsernameExists(username);
    }

    @Override
    public boolean isLoginSuccessful(String username, String password) {
        return repository.isLoginSuccessful(username, password);
    }

    @Override
    public User findUser(String username, String password) {
        User user = repository.findUser(username, password);
        return user;
    }
}
