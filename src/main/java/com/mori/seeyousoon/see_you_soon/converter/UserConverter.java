package com.mori.seeyousoon.see_you_soon.converter;

import com.mori.seeyousoon.see_you_soon.domain.User;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserResponseDTO;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserSignupRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User toUser(UserSignupRequestDTO requestDTO, String encodedPassword) {
        return User.builder()
                .email(requestDTO.getEmail())
                .name(requestDTO.getName())
                .nickname(requestDTO.getNickname())
                .password(encodedPassword)
                .build();
    }

    public static UserResponseDTO toResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
