package es.inditex.inditex.repository;

import es.inditex.inditex.repository.entity.Prices;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends CrudRepository<Prices, Integer> {

  @Query(value = "SELECT p FROM Prices p WHERE (:product_id is null OR p.productId = :product_id) "
      + "AND (:brand_id is null OR p.brandId = :brand_id) "
      + "AND (:application_date is null OR (p.startDate <= :application_date AND p.endDate > :application_date) )")
  List<Prices> findByFilter(@Param("application_date") final Timestamp applicationDate, @Param("product_id") final Integer productId,
      @Param("brand_id") final Integer brandId);
}
