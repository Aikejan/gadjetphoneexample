package aikejan.services.serviceImpl;

import aikejan.dto.request.ProductRequest;
import aikejan.dto.response.ProductResponse;
import aikejan.dto.response.SimpleResponse;
import aikejan.entity.Product;
import aikejan.repository.ProductRepository;
import aikejan.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public SimpleResponse saveProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(BigDecimal.valueOf(productRequest.getPrice()));
        product.setImage(productRequest.getImage());
        product.setIsFavorite(productRequest.isFavorite());
        product.setMadeIn(productRequest.getMadeIn());
        productRepository.save(product);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Product saved"));

    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return   productRepository.getAllProducts();

    }


    @Override
    public ProductResponse findById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();

        return null;
    }


    @Override
    public SimpleResponse deleteProductById(Long productId) {
        return null;
    }

    @Override
    public SimpleResponse updateProduct(Long id, ProductRequest productRequest) {
        return null;
    }
}


//
//
//    @Override
//    public SimpleResponse updateProduct(Long id, ProductRequest productRequest) {
//        return null;
//    }
//}
//    @Override
//    public CourseResponse getById(Long id) {
//        try {
//            return courseRepository.getCourseById(id).orElseThrow(() ->
//                    new NoSuchElementException("Course with id: " + id + " is not found!"));
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to retrieve course: " + e.getMessage());
//        }
//
//
//    }
//
//
//    @Override
//    public SimpleResponse updateCourse(Long id, CourseRequest courseRequest) {
//        try {
//            Course course = courseRepository.findById(id).orElseThrow(() ->
//                    new NoSuchElementException("Course with id: " + id + " is not found!"));
//
//            course.setName(courseRequest.getName());
//            course.setDataOfStart(courseRequest.getDataOfStart());
//            course.setDescription(courseRequest.getDescription());
//            courseRepository.save(course);
//
//            return SimpleResponse.builder()
//                    .status("SUCCESSFULLY UPDATE!")
//                    .message("Course with id: " + course.getName() + " is updated!")
//                    .build();
//
//        } catch (Exception e) {
//            return SimpleResponse.builder()
//                    .status("ERROR")
//                    .message("Failed to update course: " + e.getMessage())
//                    .build();
//        }
//
//
//    }
//
//    @Override
//    public SimpleResponse deleteById(Long id) {
//        try {
//            courseRepository.deleteById(id);
//
//            return SimpleResponse.builder()
//                    .status("SUCCESSFULLY DELETED!")
//                    .message("Course with id: " + id + " is deleted!")
//                    .build();
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to delete company: " + e.getMessage());
//        }
//    }
