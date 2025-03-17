package app.MarketSpy.app.users.mapper;


import app.MarketSpy.app.users.dtos.CreateUserRequest;
import app.MarketSpy.app.users.dtos.UserResponse;
import app.MarketSpy.app.users.model.User;

public class UserMapper {

    public static UserResponse userToResponseDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFullName(),
                user.getPhone(),
                user.getUserRole());
    }

    public static User userRequestDtoToUser(CreateUserRequest createUserRequest) {
        return User.builder()
                .email(createUserRequest.email())
                .fullName(createUserRequest.fullName())
                .password(createUserRequest.password())
                .phone(createUserRequest.phone()).build();
    }

}
