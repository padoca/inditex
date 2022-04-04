<<<<<<< HEAD
package es.inditex.inditex.controller;

import es.inditex.inditex.dto.PricesDto;
import es.inditex.inditex.service.PricesService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/prices")
public class PricesRestController {

  public static final String API_PRICES_ALL = "/all";

  public static final String API_PRICES_DELETE = "/{pricesId}";

  @Autowired
  private PricesService pricesService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PricesDto>> getPrices(@RequestParam(value = "applicationDate", required = false) final String applicationDate,
      @RequestParam(value = "productId", required = false) final Integer productId,
      @RequestParam(value = "brandId", required = false) final Integer brandId) {
    return ResponseEntity.ok(pricesService.getPricesFilter(applicationDate, productId, brandId));
  }
}
=======
package es.inditex.inditex.controller;

import es.inditex.inditex.dto.PricesDto;
import es.inditex.inditex.service.PricesService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/prices")
public class PricesRestController {

  public static final String API_PRICES_ALL = "/all";

  public static final String API_PRICES_DELETE = "/{pricesId}";

  @Autowired
  private PricesService pricesService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PricesDto>> getPrices(@RequestParam(value = "applicationDate", required = false) final String applicationDate,
      @RequestParam(value = "productId", required = false) final Integer productId,
      @RequestParam(value = "brandId", required = false) final Integer brandId) {
    return ResponseEntity.ok(pricesService.getPricesFilter(applicationDate, productId, brandId));
  }
}
>>>>>>> 634cb09a76d1bd80e46bfca4f3d4d4c863fa0b66
