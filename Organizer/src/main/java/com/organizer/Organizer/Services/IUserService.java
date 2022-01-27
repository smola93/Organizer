package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.User;

import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    boolean isUsernameExists(String username);
    boolean isLoginSuccessful(String username, String password);
    User findUser(String username, String password);
    Optional<User> getUserById(Long id);
}
