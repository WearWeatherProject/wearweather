package org.project.wearweather.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterDTO {
    private String userID;
    private String userPwd;
    private String userEmail;
    private String userPhone;
    private String userName;
    private String userAddress;
}
