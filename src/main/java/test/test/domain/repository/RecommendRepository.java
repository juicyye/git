package test.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.test.domain.entity.Recommend;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
}
