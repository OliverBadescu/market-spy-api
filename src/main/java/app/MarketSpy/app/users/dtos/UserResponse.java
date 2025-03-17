package app.MarketSpy.app.users.dtos;

import app.MarketSpy.app.system.security.UserRole;

public record UserResponse(long id, String email, String password, String fullName, String phone, UserRole userRole) {
}
