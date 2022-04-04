package es.inditex.inditex.service;

import es.inditex.inditex.dto.PricesDto;
import es.inditex.inditex.repository.PricesRepository;
import es.inditex.inditex.repository.entity.Prices;
import es.inditex.inditex.service.mapper.PricesResponseEntityMapper;
import es.inditex.inditex.util.Utils;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Service
public class PricesService {

  @Autowired
  private PricesRepository pricesRepository;

  @Autowired
  private PricesResponseEntityMapper pricesResponseEntityMapper;

  public List<PricesDto> getPricesFilter(final String applicationDate, final Integer productId, final Integer brandId) {
    Timestamp applicationDateTimestamp;
    try {
      applicationDateTimestamp = applicationDate != null ? Utils.toTimestamp(applicationDate) : null;
    } catch (ParseException e) {
      log.error("Error to parse applicationDate " + applicationDate);
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
    }
    List<Prices> result = pricesRepository.findByFilter(applicationDateTimestamp, productId, brandId);
    return result.stream().map(pricesResponseEntityMapper::toDto).collect(Collectors.toList());
  }
}
