package com.rahpors.UdemyTutorial.repository;

import com.rahpors.UdemyTutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ramon on 6/09/17.
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
    public abstract User findByUsername(String username);
}
