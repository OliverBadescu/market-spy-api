package app.MarketSpy.app.products.service;

import app.MarketSpy.app.products.dto.ProductResponse;
import app.MarketSpy.app.products.dto.ProductResponseList;

public interface ProductQueryService {

    ProductResponse findById(int id);

    ProductResponseList getAllProducts();

}
