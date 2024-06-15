package test.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.test.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
