package test.test.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.test.domain.dto.JoinDto;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String loginId;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public User(JoinDto joinDto) {
        this.name = joinDto.getName();
        this.loginId = joinDto.getLoginId();
        this.password = joinDto.getPassword();
        this.role = joinDto.getRole();
    }
}
