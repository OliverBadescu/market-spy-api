package app.MarketSpy.app.competitor_price.repository;

import app.MarketSpy.app.competitor_price.model.CompetitorPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitorPriceRepository extends JpaRepository<CompetitorPrice, Integer> {
}
