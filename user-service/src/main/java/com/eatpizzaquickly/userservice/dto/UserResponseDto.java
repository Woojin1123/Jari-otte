package com.eatpizzaquickly.userservice.dto;

import com.eatpizzaquickly.userservice.entity.User;
import com.eatpizzaquickly.userservice.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String email;
    private String nickname;
    private UserRole userRole;

    public UserResponseDto(Long id,String email, String nickname, UserRole userRole) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.userRole = userRole;
    }

    public static UserResponseDto from(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getNickname(),
                user.getUserRole()
        );
    }
}
