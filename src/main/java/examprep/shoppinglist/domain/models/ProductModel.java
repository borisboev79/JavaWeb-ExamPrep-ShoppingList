package examprep.shoppinglist.domain.models;

import examprep.shoppinglist.domain.entities.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.UniqueElements;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {

    @UniqueElements
    @Size(min = 3, max = 20)
    @NotNull
    private String name;

    @Size(min = 5)
    @NotEmpty
    private String description;

    @Positive
    @NotNull
    private BigDecimal price;

    @NotNull
    @FutureOrPresent
    private LocalDateTime neededBefore;

    @NotNull
    private String category;
}
