package app.MarketSpy.app.users.dtos;

import jakarta.validation.constraints.NotNull;

public record UpdateUserRequest(@NotNull String fullName,
                                @NotNull String email,
                                @NotNull String phone) {
}
