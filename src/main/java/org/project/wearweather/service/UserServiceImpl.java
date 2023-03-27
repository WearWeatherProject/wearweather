package org.project.wearweather.service;

import org.project.wearweather.dto.RegisterDTO;
import org.project.wearweather.entity.User;
import org.project.wearweather.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Long registerUser(RegisterDTO dto) throws Exception {
        User user = RegDtoToEntity(dto);
        userRepository.save(user);
        return user.getUserNo();
    }
}
