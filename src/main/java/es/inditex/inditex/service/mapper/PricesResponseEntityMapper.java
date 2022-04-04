<<<<<<< HEAD
package es.inditex.inditex.service.mapper;

import es.inditex.inditex.dto.PricesDto;
import es.inditex.inditex.repository.entity.Prices;
import es.inditex.inditex.util.Utils;
import org.springframework.stereotype.Component;

@Component
public class PricesResponseEntityMapper {

  public PricesDto toDto(final Prices prices) {
    return PricesDto.builder().productId(prices.getProductId()).brandId(prices.getBrandId())
        .startDate(Utils.formatDate(prices.getStartDate())).endDate(Utils.formatDate(prices.getEndDate())).priceList(prices.getPriceList()).price(prices.getPrice()).build();
  }
}
=======
package es.inditex.inditex.service.mapper;

import es.inditex.inditex.dto.PricesDto;
import es.inditex.inditex.repository.entity.Prices;
import es.inditex.inditex.util.Utils;
import org.springframework.stereotype.Component;

@Component
public class PricesResponseEntityMapper {

  public PricesDto toDto(final Prices prices) {
    return PricesDto.builder().productId(prices.getProductId()).brandId(prices.getBrandId())
        .startDate(Utils.formatDate(prices.getStartDate())).endDate(Utils.formatDate(prices.getEndDate())).priceList(prices.getPriceList()).price(prices.getPrice()).build();
  }
}
>>>>>>> 634cb09a76d1bd80e46bfca4f3d4d4c863fa0b66
