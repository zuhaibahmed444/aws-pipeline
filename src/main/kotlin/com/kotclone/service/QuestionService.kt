package com.kotclone.service

import com.kotclone.model.exam.Question
import com.kotclone.model.exam.Quiz

interface QuestionService {
    fun addQuestion(question: Question?): Question?
    fun updateQuestion(question: Question?): Question?
    fun getQuestions(): Set<Question?>?
    fun getQuestion(questionId: String?): Question?
    fun getQuestionsOfQuiz(quiz: Quiz?): Set<Question?>?
    fun deleteQuestion(quesId: String?)
    operator fun get(questionsId: String?): Question?
}