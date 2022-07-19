package ru.SSidash.Kata.PreProject_3_1_2.service;


import ru.SSidash.Kata.PreProject_3_1_2.models.User;

import java.util.List;

public interface UserService {
    List<User> listUser ();
    User getUserById (int id);
    void addUser (User user);
    void removeUser (int id);
    void updateUser (User user);
}
