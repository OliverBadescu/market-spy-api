package app.MarketSpy.app.products.service;

import app.MarketSpy.app.products.mapper.ProductMapper;
import app.MarketSpy.app.users.exceptions.NoUserFound;
import app.MarketSpy.app.users.model.User;
import app.MarketSpy.app.users.repository.UserRepository;
import lombok.AllArgsConstructor;

import app.MarketSpy.app.products.dto.CreateProductRequest;
import app.MarketSpy.app.products.dto.ProductResponse;
import app.MarketSpy.app.products.dto.UpdateProductRequest;
import app.MarketSpy.app.products.exceptions.NoProductFound;
import app.MarketSpy.app.products.model.Product;
import app.MarketSpy.app.products.repository.ProductRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Service
public class ProductCommandServiceImpl implements ProductCommandService{

    private ProductRepository productRepository;
    private UserRepository userRepository;

    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new NoUserFound("User not found"));
    }


    @Override
    public ProductResponse addProduct(CreateProductRequest createProductRequest) {
        User user = getAuthenticatedUser();

        Product product = Product.builder().name(createProductRequest.name()).user(user).build();

        productRepository.saveAndFlush(product);

        return ProductMapper.productToResponseDto(product);

    }

    @Override
    public ProductResponse deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoProductFound("No product with this id found"));

        ProductResponse productResponse = ProductMapper.productToResponseDto(product);
        productRepository.delete(product);
        return productResponse;
    }

    @Override
    public void updateProduct(int id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoProductFound("No product with this id found"));


        product.setName(updateProductRequest.name());

    }




}
