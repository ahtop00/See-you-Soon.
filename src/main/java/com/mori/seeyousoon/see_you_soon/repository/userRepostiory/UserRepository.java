package com.mori.seeyousoon.see_you_soon.repository.userRepostiory;

import com.mori.seeyousoon.see_you_soon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
