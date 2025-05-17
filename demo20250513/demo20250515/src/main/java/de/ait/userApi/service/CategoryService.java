package de.ait.userApi.service;

import de.ait.userApi.dto.CategoryRequestDto;
import de.ait.userApi.dto.CategoryResponseDto;
import de.ait.userApi.dto.ProductRequestDto;
import de.ait.userApi.dto.ProductResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto getCategoryById(Long id);
    CategoryResponseDto save(CategoryRequestDto dto);
}
