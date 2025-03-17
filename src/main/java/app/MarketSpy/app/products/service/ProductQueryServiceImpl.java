package app.MarketSpy.app.products.service;

import lombok.AllArgsConstructor;

import app.MarketSpy.app.products.dto.ProductResponse;
import app.MarketSpy.app.products.dto.ProductResponseList;
import app.MarketSpy.app.products.exceptions.NoProductFound;
import app.MarketSpy.app.products.mapper.ProductMapper;
import app.MarketSpy.app.products.model.Product;
import app.MarketSpy.app.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@AllArgsConstructor
@Service
public class ProductQueryServiceImpl implements ProductQueryService{

    private final ProductRepository productRepository;


    @Override
    public ProductResponse findById(int id) {

        return ProductMapper.productToResponseDto(productRepository.findById(id)
                .orElseThrow(() -> new NoProductFound("No product with this id found")));

    }

    @Override
    public ProductResponseList getAllProducts() {
        List<Product> list = productRepository.findAll();

        List<ProductResponse> responses = new ArrayList<>();

        list.forEach(product -> {
            responses.add(ProductMapper.productToResponseDto(product));
        });
        return new ProductResponseList(responses);
    }

}
