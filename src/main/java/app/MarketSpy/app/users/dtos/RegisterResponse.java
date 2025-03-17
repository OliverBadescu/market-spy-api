package app.MarketSpy.app.users.dtos;


import app.MarketSpy.app.system.security.UserRole;

public record RegisterResponse(String jwtToken,
                               String fullName,
                               String phone,
                               String email,
                               UserRole userRole) {
}
