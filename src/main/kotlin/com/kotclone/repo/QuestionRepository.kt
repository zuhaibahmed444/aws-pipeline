package com.kotclone.repo

import com.kotclone.model.exam.Question
import com.kotclone.model.exam.Quiz
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : MongoRepository<Question,String> {
    fun findByQuiz(quiz: Quiz?): Set<Question?>?
    fun save(question: Question?): Question
    fun findById(questionsId: String?) : Question

}