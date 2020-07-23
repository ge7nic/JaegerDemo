package de.cas.jaegerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.cas.jaegerdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
