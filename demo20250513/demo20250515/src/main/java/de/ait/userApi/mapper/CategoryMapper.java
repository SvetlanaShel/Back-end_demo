package de.ait.userApi.mapper;

import de.ait.userApi.dto.CategoryRequestDto;
import de.ait.userApi.dto.CategoryResponseDto;
import de.ait.userApi.dto.ProductRequestDto;
import de.ait.userApi.dto.ProductResponseDto;
import de.ait.userApi.model.Category;
import de.ait.userApi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category fromDto(CategoryRequestDto dto);
    CategoryResponseDto toDto (Category category);
    List<CategoryResponseDto> toDtoList (List<Category> category);
}
