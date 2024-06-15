package test.test.domain.entity;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_USER("유저"), ROLE_ADMIN("관리자"), ROLE_MANAGER("매니저");
    String description;

    Role(String description) {
        this.description = description;
    }
}
