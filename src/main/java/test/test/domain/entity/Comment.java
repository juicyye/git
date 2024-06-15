package test.test.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToMany(mappedBy = "comment")
    private List<Recommend> recommends = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String content) {
        this.content = content;
    }

    /**
     * 편의 메서드
     */





}
