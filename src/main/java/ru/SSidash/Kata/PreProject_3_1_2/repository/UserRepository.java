package ru.SSidash.Kata.PreProject_3_1_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.SSidash.Kata.PreProject_3_1_2.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
