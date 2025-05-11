package com.nsa.repository;

import com.nsa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {


    // @Query(value = "SELECT * FROM student WHERE id = id", nativeQuery = true)
    @Query(value = "SELECT a FROM Address a WHERE a.id = :id")
    Optional<Address> getAddressById(Long id);

}
