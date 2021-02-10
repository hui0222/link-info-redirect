package kr.co.lir.repository.user;

import kr.co.lir.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    // email로 처음 사용자인지 아닌지 판별
    Optional<User> findByEmail(String email);
}
