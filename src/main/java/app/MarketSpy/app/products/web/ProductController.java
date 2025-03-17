package app.MarketSpy.app.products.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import app.MarketSpy.app.products.dto.CreateProductRequest;
import app.MarketSpy.app.products.dto.ProductResponse;
import app.MarketSpy.app.products.dto.ProductResponseList;
import app.MarketSpy.app.products.dto.UpdateProductRequest;
import app.MarketSpy.app.products.service.ProductCommandService;
import app.MarketSpy.app.products.service.ProductQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    private ProductQueryService productQueryService;
    private ProductCommandService productCommandService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addProduct/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody CreateProductRequest createProductRequest){
        return new ResponseEntity<>(productCommandService.addProduct(createProductRequest), HttpStatus.CREATED);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN') ")
    @DeleteMapping(path = "/deleteProduct/{productId}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable int productId){
        return new ResponseEntity<>(productCommandService.deleteProduct(productId), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(path ="/updateProduct/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable int productId, @Valid @RequestBody UpdateProductRequest updateProductRequest){

        productCommandService.updateProduct(productId,updateProductRequest);

        ProductResponse productResponse = productQueryService.findById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.ACCEPTED);

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_CLIENT')")
    @GetMapping("/getAllProducts")
    public  ResponseEntity<ProductResponseList> getAllProducts(){
        return new ResponseEntity<>(productQueryService.getAllProducts(), HttpStatus.OK);
    }



}
