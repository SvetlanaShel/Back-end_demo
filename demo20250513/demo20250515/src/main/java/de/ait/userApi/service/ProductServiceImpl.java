package de.ait.userApi.service;

import de.ait.userApi.dto.ProductRequestDto;
import de.ait.userApi.dto.ProductResponseDto;
import de.ait.userApi.mapper.ProductMapper;
import de.ait.userApi.model.Category;
import de.ait.userApi.model.Product;
import de.ait.userApi.repository.CategoryRepository;
import de.ait.userApi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;


    @Override
    public List<ProductResponseDto> getProducts() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ProductResponseDto save(ProductRequestDto dto) {
        Product product = mapper.fromDto(dto);
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        Product saved = repository.save(product);
        return mapper.toDto(saved);
    }
}
