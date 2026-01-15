package com.mfs.Emailverification.Repository;

import com.mfs.Emailverification.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserEmailIgnoreCase(String userEmail);
    Boolean existsByUserEmail(String userEmail);
}
