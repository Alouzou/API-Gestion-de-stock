package com.example.gestiondestock.services.Impl;

import com.example.gestiondestock.dto.CategoryDto;
import com.example.gestiondestock.exception.EntityNotFoundException;
import com.example.gestiondestock.exception.ErrorCodes;
import com.example.gestiondestock.exception.InvalidEntityException;
import com.example.gestiondestock.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void shouldThrowEntityNotFoundException(){

        EntityNotFoundException expectedException =  assertThrows(EntityNotFoundException.class, () -> service.findById(0));
        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Aucune category avec l'ID = 0 n' ete trouve dans la BDD", expectedException.getMessage());

    }


    @Test
    public void shouldSaveCategoryWithSuccess(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("category Tset")
                .designation("Design test")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = service.save(expectedCategory);

        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals(expectedCategory.getCode(), savedCategory.getCode());
        assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation());
        assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise());
    }

    @Test
    public void shouldUpdateCategoryWithSuccess(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("category Tset")
                .designation("Design test")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = service.save(expectedCategory);

        CategoryDto categoryToUpdate = savedCategory;
        categoryToUpdate.setCode("code cat updated");

        savedCategory = service.save(categoryToUpdate);

        assertNotNull(categoryToUpdate);
        assertNotNull(categoryToUpdate.getId());
        assertEquals(categoryToUpdate.getCode(), savedCategory.getCode());
        assertEquals(categoryToUpdate.getDesignation(), savedCategory.getDesignation());
        assertEquals(categoryToUpdate.getIdEntreprise(), savedCategory.getIdEntreprise());
    }

    @Test
    public void shouldThrowInvalidEntityException(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .build();

        InvalidEntityException expectedException =  assertThrows(InvalidEntityException.class, () -> service.save(expectedCategory));
        assertEquals(ErrorCodes.CATEGORY_NOT_VALID, expectedException.getErrorCode());
        assertEquals("Veuillez renseigner le code de la categorie", expectedException.getErrors().get(0));
        assertEquals(1, expectedException.getErrors().size());
    }

}