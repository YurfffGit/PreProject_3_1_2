package ru.SSidash.Kata.PreProject_3_1_2.service;

import org.springframework.stereotype.Service;
import ru.SSidash.Kata.PreProject_3_1_2.models.Role;
import ru.SSidash.Kata.PreProject_3_1_2.repository.RoleRepository;


import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Collection<Role> getRoleList() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int id) {
        return roleRepository.getById(id);
    }
}
