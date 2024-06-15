package test.test.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.test.domain.entity.Role;
import test.test.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private Role role;

    public static List<UserDto> toDto(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(UserDto.toDto(user));
        }
        return dtos;
    }

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
