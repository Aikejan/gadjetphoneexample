package aikejan.api;

import aikejan.dto.request.ProductRequest;
import aikejan.dto.response.ProductResponse;
import aikejan.dto.response.SimpleResponse;
import aikejan.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "ProductAPI")
@RequiredArgsConstructor
public class ProductAPI {
    private  final ProductService productService;

    @Secured({"ADMIN"})
    @PostMapping
   // @Operation(summary = "Save", description = "Input the product")  /// productun surottolushu jasabyz
    SimpleResponse saveProduct(@RequestBody ProductRequest productRequest){
      return   productService.saveProduct(productRequest);

    }
    @Secured({"ADMIN"})
    @GetMapping
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProducts();
    }

}
