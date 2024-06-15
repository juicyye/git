package test.test.domain.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import test.test.domain.entity.Comment;
import test.test.domain.entity.Recommend;
import test.test.domain.entity.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RecommendRepositoryTest {
    @Autowired
    private RecommendRepository recommendRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        User user = new User("유저");
        userRepository.save(user);

        Comment comment = new Comment("댓글1");
        comment.setUser(user);
        commentRepository.save(comment);

        Comment comment1 = new Comment("댓글2");
        comment.setUser(user);
        commentRepository.save(comment1);




    }


    @Test
    @DisplayName("댓글과 추천의 연관관계")
    @Rollback
    void recommend(){
        User findUser = userRepository.findById(1L).orElse(null);
        Comment findComment1 = commentRepository.findById(1L).orElse(null);

        Recommend recommend1 = new Recommend();
        recommend1.addRecommend(findComment1,findUser);
        recommendRepository.save(recommend1);

        Recommend recommend2 = new Recommend();
        recommend2.addRecommend(findComment1,findUser);
        recommendRepository.save(recommend2);

        Comment comment = commentRepository.findById(1L).orElse(null);
        List<Recommend> recommends = comment.getRecommends();
        for (Recommend recommend : recommends) {
            System.out.println("recommend.getId() = " + recommend.getId());
        }
        assertThat(recommends.size()).isEqualTo(2);

    }
}