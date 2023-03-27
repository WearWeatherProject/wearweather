package org.project.wearweather.service;

import lombok.RequiredArgsConstructor;
import org.project.wearweather.dto.RegisterDTO;
import org.project.wearweather.entity.User;
import org.project.wearweather.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Long registerUser(RegisterDTO dto) throws Exception {
        User userEntity = RegDtoToEntity(dto);
        userRepository.save(userEntity);
        System.out.println("회원가입 성공!!!!! 유저아이디 : "+userEntity.getUserID());
        return userEntity.getUserNo();
    }
}
