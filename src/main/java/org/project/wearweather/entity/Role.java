package org.project.wearweather.entity;

import lombok.Getter;


@Getter
public enum Role {
    ROLE_ADMIN("관리자"), ROLE_USER("일반사용자");
    //ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
    private String description;
    Role (){}
    Role(String description) {
        this.description = description;
    }
}
