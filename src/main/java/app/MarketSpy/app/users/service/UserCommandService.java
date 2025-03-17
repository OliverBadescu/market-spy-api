package app.MarketSpy.app.users.service;

import app.MarketSpy.app.users.dtos.CreateUserRequest;
import app.MarketSpy.app.users.dtos.UpdateUserRequest;
import app.MarketSpy.app.users.dtos.UserResponse;

public interface UserCommandService {

    UserResponse createUser(CreateUserRequest createUserRequest);

    UserResponse deleteUser(long id);

    UserResponse updateUser(UpdateUserRequest updateUserRequest, long id);

}
