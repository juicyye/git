package test.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.test.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginId(String loginId);
}
