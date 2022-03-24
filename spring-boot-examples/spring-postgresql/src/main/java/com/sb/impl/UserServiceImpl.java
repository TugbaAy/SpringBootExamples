package com.sb.impl;

import com.sb.dto.UserDTO;
import com.sb.entity.Address;
import com.sb.entity.AddressType;
import com.sb.entity.User;
import com.sb.repository.AddressRepository;
import com.sb.repository.UserRepository;
import com.sb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user = userRepository.save(user);

        List<Address> addressList = new ArrayList<>();

        User finalUser = user;
        userDTO.getAddressList().forEach(x -> {
            Address address = new Address();
            address.setAddress(x);
            address.setAddressType(AddressType.HOME);
            address.setActive(true);
            address.setUser(finalUser);
            addressList.add(address);
        });

        addressRepository.saveAll(addressList);

        finalUser.setAddressList(addressList);
        userRepository.save(finalUser);

        userDTO.setId(finalUser.getId());

        return userDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDTO getById(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        if (userList != null) {
            userList.forEach(a -> {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(a.getId());
                userDTO.setName(a.getName());
                userDTO.setSurname(a.getSurname());
                userDTO.setAddressList(a.getAddressList()
                        .stream()
                        .map(Address::getAddress)
                        .collect(Collectors.toList()));

                userDTOS.add(userDTO);
            });
        }
        return userDTOS;
    }


}
