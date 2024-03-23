package com.pet.repository;

import com.pet.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Long> {

    Optional<UserDetails> findByUserNameAndPassword(String userName,String password);

    Optional<UserDetails> findByUserName(String userName);
}
