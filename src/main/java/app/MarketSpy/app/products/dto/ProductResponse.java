package app.MarketSpy.app.products.dto;

import app.MarketSpy.app.users.dtos.UserResponse;
import lombok.Builder;


@Builder
public record ProductResponse(Long id, String name, UserResponse user)   {
}
