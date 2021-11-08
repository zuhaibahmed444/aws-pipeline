package com.kotclone.service

import com.kotclone.model.exam.Category

interface CategoryService {
    fun addCategory(category: Category?): Category?
    fun updateCategory(category: Category?): Category?
    fun getCategories(): LinkedHashSet<Category?>
    fun getCategory(categoryId: String?): Category?
    fun deleteCategory(categoryId: String?)
}