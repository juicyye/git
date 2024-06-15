package test.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.test.domain.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
