package test.test.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.test.domain.entity.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private Role role;
}
