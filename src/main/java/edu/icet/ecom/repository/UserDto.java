package edu.icet.ecom.repository;

import edu.icet.ecom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDto extends JpaRepository <UserEntity,Long> {

    UserEntity findByUserNameAndPassword(String userName , String password);

}
