package examprep.shoppinglist.services.product;

import examprep.shoppinglist.domain.entities.Product;
import examprep.shoppinglist.domain.enums.CategoryType;
import examprep.shoppinglist.repositories.CategoryRepository;
import examprep.shoppinglist.repositories.ProductRepository;
import examprep.shoppinglist.services.DatabaseInitialization;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService, DatabaseInitialization {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    @Override
    public void dbInit() {
        if(!isDbInit()){
            this.productRepository.saveAndFlush(Product.builder()
                    .name("Верея 3.6")
                    .price(BigDecimal.valueOf(1.50))
                    .category(this.categoryRepository.findByName(CategoryType.Food))
                    .neededBefore(LocalDateTime.of(2023, 2,23,6,30))
                    .description("Кисело мляко")
                    .build());

        }
    }

    @Override
    public boolean isDbInit() {
        return this.productRepository.count() > 0;
    }
}
