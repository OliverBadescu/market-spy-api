package app.MarketSpy.app.products.service;

import app.MarketSpy.app.products.dto.CreateProductRequest;
import app.MarketSpy.app.products.dto.ProductResponse;
import app.MarketSpy.app.products.dto.UpdateProductRequest;

public interface ProductCommandService {

    ProductResponse addProduct(CreateProductRequest createProductRequest);

    ProductResponse deleteProduct(int id);

    void updateProduct(int id, UpdateProductRequest updateProductRequest);

}
