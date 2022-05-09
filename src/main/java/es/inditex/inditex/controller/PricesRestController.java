
package es.inditex.inditex.controller;

import es.inditex.inditex.dto.PricesDto;
import es.inditex.inditex.service.PricesService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest service exposed for inditex prices.
 */
@Slf4j
@RestController
@RequestMapping("/api/prices")
public class PricesRestController {

  @Autowired
  private PricesService pricesService;

  /**
   * Get prices.
   *
   * @param applicationDate Date of products.
   * @param productId Identification of the product.
   * @param brandId Brand identification.
   * @return List of prices.
   */
  @ApiOperation(value = "Get Prices Operation", notes = "Devolvemos La lista de precios respecto a la fecha de aplicación, identificador de producto, identificador de cadena")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = PricesDto.class ),
          @ApiResponse(code = 400, message = "Bad Request", response = String.class),
          @ApiResponse(code = 500, message = "Error inesperado del sistema") })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PricesDto>> getPrices(
          @ApiParam(name =  "applicationDate", type = "LocalDateTime", value = "Fecha de aplicación", example = "2020-06-14-21.00.00", required = false)
          @RequestParam(value = "applicationDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") final LocalDateTime applicationDate,
          @ApiParam(name =  "productId", type = "Integer", value = "Identificador de producto", example = "35455", required = false)
          @RequestParam(value = "productId", required = false) final Integer productId,
          @ApiParam(name =  "brandId", type = "Integer", value = "Identificador de cadena", example = "1", required = false)
          @RequestParam(value = "brandId", required = false) final Integer brandId) {
    return ResponseEntity.ok(pricesService.getPricesFilter(applicationDate, productId, brandId));
  }
}
