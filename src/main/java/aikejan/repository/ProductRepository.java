package aikejan.repository;

import aikejan.dto.response.ProductResponse;
import aikejan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select new aikejan.dto.response.ProductResponse(p.id,p.name,p.price,p.image) from Product p")
    List<ProductResponse> getAllProducts();
}
