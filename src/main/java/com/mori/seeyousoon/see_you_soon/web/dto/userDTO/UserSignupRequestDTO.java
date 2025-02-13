package com.mori.seeyousoon.see_you_soon.web.dto.userDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignupRequestDTO {
    private String email;
    private String password;
    private String name;
    private String nickname;
}
