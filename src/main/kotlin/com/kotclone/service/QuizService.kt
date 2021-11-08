package com.kotclone.service

import com.kotclone.model.exam.Category
import com.kotclone.model.exam.Quiz

interface QuizService {

    fun addQuiz(quiz: Quiz?): Quiz?
    fun updateQuiz(quiz: Quiz?): Quiz?
    fun getQuiz(quizId: String?): Quiz?
    fun quizzes(): Set<Quiz?>?
    fun deleteQuiz(quizId: String?)
    fun getQuizzesOfCategory(category: Category?): List<Quiz?>?
    fun getActiveQuizzes(): List<Quiz?>?
    fun getActiveQuizzesOfCategory(c: Category?): List<Quiz?>?

}