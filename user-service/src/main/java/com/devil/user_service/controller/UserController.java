package com.devil.user_service.controller;

import com.devil.user_service.model.User;
import com.devil.user_service.model.UserDto;
import com.devil.user_service.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    @GetMapping
    public List<UserDto> getAllUser(){
       return userRepository.findAll()
                               .stream().map(this::convertToUserDto)
                               .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) throws Exception {
         User user =userRepository.findById(id).get();
        return convertToUserDto(user);
    }
    @PostMapping
    public UserDto addUser(@RequestBody User user){
        User saveThisUser = userRepository.save(user);
        return convertToUserDto(saveThisUser);
    }

}
