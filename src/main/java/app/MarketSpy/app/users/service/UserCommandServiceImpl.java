package app.MarketSpy.app.users.service;


import lombok.AllArgsConstructor;

import app.MarketSpy.app.system.security.UserRole;
import app.MarketSpy.app.users.dtos.CreateUserRequest;
import app.MarketSpy.app.users.dtos.UpdateUserRequest;
import app.MarketSpy.app.users.dtos.UserResponse;
import app.MarketSpy.app.users.exceptions.NoUserFound;
import app.MarketSpy.app.users.exceptions.UserAlreadyExists;
import app.MarketSpy.app.users.mapper.UserMapper;
import app.MarketSpy.app.users.model.User;
import app.MarketSpy.app.users.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserCommandServiceImpl implements UserCommandService{

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;



    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user  = User.builder()
                .phone(createUserRequest.phone())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .fullName(createUserRequest.fullName())
                .email(createUserRequest.email())
                .userRole(UserRole.CLIENT)
                .build();

        List<User> list = userRepository.findAll();

        list.forEach( user1 -> {
            if(user.getEmail().equals(user1.getEmail())){
                throw new UserAlreadyExists("User with this email already exists");
            }
        });

        userRepository.saveAndFlush(user);

        return UserMapper.userToResponseDto(user);
    }

    @Override
    public UserResponse deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));


        UserResponse response = UserMapper.userToResponseDto(user);

        userRepository.delete(user);

        return response;
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest up, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));

        List<User> list = userRepository.findAll();
        list.remove(user);

        list.forEach( user1 -> {
            if(up.email().equals(user1.getEmail())){
                throw new UserAlreadyExists("User with this email already exists, please enter a different email address");
            }
        });
        user.setEmail(up.email());
        user.setFullName(up.fullName());
        user.setPhone(up.phone());

        userRepository.save(user);

        return UserMapper.userToResponseDto(user);
    }
}
