package de.ait.userApi.mapper;

import de.ait.userApi.dto.ProductRequestDto;
import de.ait.userApi.dto.ProductResponseDto;
import de.ait.userApi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromDto(ProductRequestDto dto);
    ProductResponseDto toDto (Product product);
    List<ProductResponseDto> toDtoList (List<Product> product);
}
