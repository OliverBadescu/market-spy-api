package app.MarketSpy.app.products.mapper;

import app.MarketSpy.app.users.mapper.UserMapper;
import lombok.Builder;
import app.MarketSpy.app.products.dto.ProductResponse;
import app.MarketSpy.app.products.model.Product;

@Builder
public class ProductMapper {


    public static ProductResponse productToResponseDto(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .user(UserMapper.userToResponseDto(product.getUser()))
                .name(product.getName())
                .build();
    }

    public static Product responseDtoToProduct(ProductResponse product){
        return Product.builder()
                .id(product.id())
                .name(product.name())
                .build();
    }

}
