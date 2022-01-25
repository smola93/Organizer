package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.User;

public interface IUserService {
    User createUser(User user);
    boolean isUsernameExists(String username);
}
