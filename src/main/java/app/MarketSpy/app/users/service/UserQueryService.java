    package app.MarketSpy.app.users.service;

    import app.MarketSpy.app.users.dtos.UserResponse;
    import app.MarketSpy.app.users.dtos.UserResponseList;
    import app.MarketSpy.app.users.model.User;

    public interface UserQueryService {

        UserResponse findUserById(long id);

        UserResponseList getAllUsers();

        User findByEmail(String email);


    }
