package com.kotclone.repo

import com.kotclone.model.exam.Category
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : MongoRepository<Category,String> {
    fun save(category: Category?): Category?


}