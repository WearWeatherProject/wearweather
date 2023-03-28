package org.project.wearweather.service;

import lombok.RequiredArgsConstructor;
import org.project.wearweather.dto.UserDTO;
import org.project.wearweather.entity.User;
import org.project.wearweather.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Long registerUser(UserDTO dto) throws Exception {
        User userEntity = RegDtoToEntity(dto);
        userRepository.save(userEntity);
        System.out.println("회원가입 성공!!!!! 유저아이디 : "+userEntity.getUserID());
        return userEntity.getUserNo();
    }
}
