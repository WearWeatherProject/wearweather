package org.project.wearweather.service;

import org.project.wearweather.dto.RegisterDTO;
import org.project.wearweather.entity.Role;
import org.project.wearweather.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface UserService {
    public Long registerUser(RegisterDTO dto) throws Exception;




    //회원가입시 dto -> 엔터티 변환
    default User RegDtoToEntity(RegisterDTO dto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User entity = User.builder()
                .userID(dto.getUserID())
                .userPwd(passwordEncoder.encode(dto.getUserPwd()))
                .userEmail(dto.getUserEmail())
                .userName(dto.getUserName())
                .userAddress(dto.getUserAddress())
                .userPhone(dto.getUserPhone())
                .role(Role.ROLE_USER)
                .mileage(0)
                .build();
        return entity;
    }
}
