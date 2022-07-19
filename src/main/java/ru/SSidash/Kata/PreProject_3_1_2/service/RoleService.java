package ru.SSidash.Kata.PreProject_3_1_2.service;


import ru.SSidash.Kata.PreProject_3_1_2.models.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getRoleList();
    Role getRoleById(int id);
}
