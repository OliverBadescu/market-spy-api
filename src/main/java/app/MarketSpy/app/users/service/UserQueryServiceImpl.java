package app.MarketSpy.app.users.service;

import lombok.AllArgsConstructor;

import app.MarketSpy.app.users.dtos.UserResponse;
import app.MarketSpy.app.users.dtos.UserResponseList;
import app.MarketSpy.app.users.exceptions.NoUserFound;
import app.MarketSpy.app.users.mapper.UserMapper;
import app.MarketSpy.app.users.model.User;
import app.MarketSpy.app.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserQueryServiceImpl implements UserQueryService{

    private UserRepository userRepository;

    @Override
    public UserResponse findUserById(long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));

        return UserMapper.userToResponseDto(user);
    }

    @Override
    public UserResponseList getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();

        list.forEach(user -> {
            responses.add(UserMapper.userToResponseDto(user));
        });

        return new UserResponseList(responses);
    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email).orElseThrow(() -> new NoUserFound("No user with this email found"));
    }


}
