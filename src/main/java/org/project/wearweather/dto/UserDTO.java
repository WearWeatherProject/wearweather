package org.project.wearweather.dto;

import lombok.*;
import org.project.wearweather.entity.Role;
import org.project.wearweather.entity.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String userID;
    private String userPwd;
    private String userEmail;
    private String userPhone;
    private String userName;
    private String userAddress;

    private Role role;


    /* DTO ->Entity */
    public User toEntity() {
        User user = User.builder()
                .userID(userID)
                .userPwd(userPwd)
                .userName(userName)
                .userEmail(userEmail)
                .role(role)
                .build();

        return user;
    }

    @Builder
    public UserDTO(String userID, String userPwd, Role role) {
        this.userID = userID;
        this.userPwd = userPwd;
        this.role = role;
    }

}
