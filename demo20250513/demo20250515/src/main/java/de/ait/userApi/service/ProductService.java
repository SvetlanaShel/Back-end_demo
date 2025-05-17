package de.ait.userApi.service;

import de.ait.userApi.dto.ProductRequestDto;
import de.ait.userApi.dto.ProductResponseDto;


import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getProducts();
    ProductResponseDto getProductById(Long id);
    ProductResponseDto save(ProductRequestDto dto);
}
