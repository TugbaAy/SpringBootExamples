package com.sb.service;

import com.sb.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    void delete(Long id);

    UserDTO getById(Long id);

    List<UserDTO> getAllUsers();

}
