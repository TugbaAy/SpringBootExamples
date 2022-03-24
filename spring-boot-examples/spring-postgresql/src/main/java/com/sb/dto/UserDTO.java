package com.sb.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String surname;

    private List<String> addressList;

}
