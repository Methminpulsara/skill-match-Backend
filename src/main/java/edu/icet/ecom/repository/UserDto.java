package edu.icet.ecom.repository;

import edu.icet.ecom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDto extends JpaRepository <UserEntity,Long> {

    UserEntity findByEmailAndPassword(String email,String password);

    Optional<UserEntity> findByEmail(String email);
}
