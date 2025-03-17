package app.MarketSpy.app.users.dtos;


import app.MarketSpy.app.system.security.UserRole;

public record LoginResponse(String jwtToken,
                            Long id,
                            String fullName,
                            String phone,
                            String email,
                            UserRole userRole) {
}
