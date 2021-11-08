package com.kotclone

import com.kotclone.model.exam.Category
import com.kotclone.repo.CategoryRepository
import com.kotclone.service.CategoryService
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class CategoryServiceTest {

    @Autowired
    val categoryService: CategoryService?=null

    @Mock
    val categoryRepository :CategoryRepository?=null

    val category : Category = Category("Bio-Physics","This Category consist of quizzez od bio")

    @Test
    fun addCategoryTest(){
        `when`(categoryRepository?.save(category)).thenReturn(category)
        assertEquals(category,categoryService?.addCategory(category))
    }

    @Test
    fun updateCategoryTest(){
        `when`(categoryRepository?.save(category)).thenReturn(category)
        assertEquals(category,categoryService?.updateCategory(category))
    }

    @Test
    fun deleteCategoryTest(){
        val catid :String = "cc1de54f-2bbc-11ec-ba24-d355700766d0"
        assertEquals(kotlin.Unit,categoryService?.deleteCategory(catid))
    }

}