package ru.SSidash.Kata.PreProject_3_1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.SSidash.Kata.PreProject_3_1_2.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
