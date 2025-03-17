package app.MarketSpy.app.competitor_price.model;


import app.MarketSpy.app.products.model.Product;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Table(name = "competitor_prices")
@Entity(name = "competitorPrice")
public class CompetitorPrice {

    @Id
    @SequenceGenerator(
            name = "competitor_price_sequence",
            sequenceName = "competitor_price_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "competitor_price_sequence"
    )
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false, name = "competitor")
    private String competitor;

    @Column(nullable = false, name = "price")
    private Double price;
}
