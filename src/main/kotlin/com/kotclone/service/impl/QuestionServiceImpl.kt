package com.kotclone.service.impl

import com.fasterxml.uuid.Generators
import com.kotclone.model.exam.Question
import com.kotclone.model.exam.Quiz
import com.kotclone.repo.QuestionRepository
import com.kotclone.service.QuestionService
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashSet

@Service
class QuestionServiceImpl(private val questionRepository: QuestionRepository) : QuestionService {

    override fun addQuestion(question: Question?): Question? {
        val uuid : UUID = Generators.timeBasedGenerator().generate()
        question?.quesId = uuid.toString()
        return questionRepository.save(question)
    }

    override fun updateQuestion(question: Question?): Question? {
        return questionRepository.save(question)
    }

    override fun getQuestions(): Set<Question?>? {
        return HashSet(questionRepository.findAll())
    }

    override fun getQuestion(questionId: String?): Question? {
        return questionRepository.findById(questionId!!).get()
    }

    override fun getQuestionsOfQuiz(quiz: Quiz?): Set<Question?>? {
        return questionRepository.findByQuiz(quiz)
    }

    override fun deleteQuestion(quesId: String?) {
        val question = Question()
        question.quesId = quesId!!

        questionRepository.delete(question)
    }

    //to get single question using questionId
    override fun get(questionsId: String?): Question? {
        return questionRepository.findById(questionsId)
    }
}