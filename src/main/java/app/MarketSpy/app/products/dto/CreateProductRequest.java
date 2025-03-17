package app.MarketSpy.app.products.dto;

import lombok.Builder;

@Builder
public record CreateProductRequest(String name) {

}