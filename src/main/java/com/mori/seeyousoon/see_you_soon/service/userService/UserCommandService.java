package com.mori.seeyousoon.see_you_soon.service.userService;

import com.mori.seeyousoon.see_you_soon.converter.UserConverter;
import com.mori.seeyousoon.see_you_soon.domain.User;
import com.mori.seeyousoon.see_you_soon.repository.userRepostiory.UserRepository;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserLoginRequestDTO;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserResponseDTO;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserSignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 회원 가입 서비스 (비밀번호 BCrypt 적용)
     * @param request UserSignupRequestDTO
     * @return UserResponseDTO
     */
    public UserResponseDTO signup(UserSignupRequestDTO request) {
        // 이메일 중복 체크
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        // 비밀번호 해싱
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // User 엔티티 생성 후 저장
        User user = UserConverter.toUser(request, encodedPassword);

        userRepository.save(user);
        return UserConverter.toResponseDTO(user);
    }

    /**
     * 로그인 서비스
     * @param request UserLoginRequestDTO
     * @return UserResponseDTO
     */
    public UserResponseDTO login(UserLoginRequestDTO request) {
        // 이메일로 유저 조회
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return UserConverter.toResponseDTO(user);
    }
}
