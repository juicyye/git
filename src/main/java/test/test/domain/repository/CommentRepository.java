package test.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.test.domain.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
