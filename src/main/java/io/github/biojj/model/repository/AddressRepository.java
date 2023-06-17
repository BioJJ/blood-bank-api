package io.github.biojj.model.repository;

import io.github.biojj.model.entity.Address;
import io.github.biojj.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

} 