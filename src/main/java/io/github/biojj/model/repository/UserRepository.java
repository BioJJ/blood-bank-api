package io.github.biojj.model.repository;

import io.github.biojj.model.entity.Candidate;
import io.github.biojj.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

} 