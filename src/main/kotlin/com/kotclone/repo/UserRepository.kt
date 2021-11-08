package com.kotclone.repo

import com.kotclone.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User,String>{
    fun findByUsername(username: String?): User?
}