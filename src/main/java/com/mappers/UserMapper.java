package com.mappers;

import com.dtos.UserDTO;
import com.models.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }
}
