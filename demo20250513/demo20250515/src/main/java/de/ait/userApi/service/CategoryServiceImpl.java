package de.ait.userApi.service;

import de.ait.userApi.dto.CategoryRequestDto;
import de.ait.userApi.dto.CategoryResponseDto;
import de.ait.userApi.mapper.CategoryMapper;
import de.ait.userApi.model.Category;
import de.ait.userApi.model.Product;
import de.ait.userApi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private  final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryResponseDto> getCategories() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto dto) {
        Category category = mapper.fromDto(dto);
        Category saved = repository.save(category);
        return mapper.toDto(saved);
    }
}
