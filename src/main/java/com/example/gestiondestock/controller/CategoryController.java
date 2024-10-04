package com.example.gestiondestock.controller;

import com.example.gestiondestock.controller.api.CategoryApi;
import com.example.gestiondestock.dto.CategoryDto;

import java.util.List;

public class CategoryController implements CategoryApi {
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto findById(Integer id) {
        return null;
    }

    @Override
    public CategoryDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
