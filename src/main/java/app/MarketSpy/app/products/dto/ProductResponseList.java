package app.MarketSpy.app.products.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ProductResponseList(List<ProductResponse> list) {
}
