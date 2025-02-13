package com.mori.seeyousoon.see_you_soon.web.controller;

import com.mori.seeyousoon.see_you_soon.service.userService.UserCommandService;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserLoginRequestDTO;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserResponseDTO;
import com.mori.seeyousoon.see_you_soon.web.dto.userDTO.UserSignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserCommandService userService;

    // 회원가입
    @PostMapping("/signup")
    public UserResponseDTO signup(@RequestBody UserSignupRequestDTO request) {
        return userService.signup(request);
    }

    // 로그인
    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody UserLoginRequestDTO request) {
        return userService.login(request);
    }

    // 회원 조회, 수정, 탈퇴(삭제)도 구현 가능
    // ...
}
