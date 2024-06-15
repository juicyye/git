package test.test.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "recommend")
//    private List<RecommedComment> recommedComments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommend_id")
    private Comment comment;

    /**
     * 편의 메서드
     */

    public void addRecommend(Comment comment, User user) {
        this.user= user;
        changeComment(comment);

    }

    private void changeComment(Comment comment) {
        this.comment = comment;
        comment.getRecommends().add(this);
    }



}
