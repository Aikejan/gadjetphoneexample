package aikejan.services;

import aikejan.dto.request.ProductRequest;
import aikejan.dto.response.ProductResponse;
import aikejan.dto.response.SimpleResponse;

import java.util.List;

public interface ProductService {
 SimpleResponse saveProduct(ProductRequest productRequest);
   List<ProductResponse> getAllProducts();
   ProductResponse findById(Long productId);

    SimpleResponse deleteProductById(Long productId);

    SimpleResponse updateProduct(Long id, ProductRequest productRequest);


}
