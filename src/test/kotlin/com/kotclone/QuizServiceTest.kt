package com.kotclone

import com.kotclone.model.exam.Quiz
import com.kotclone.repo.QuizRepository
import com.kotclone.service.QuizService
import org.junit.Assert.assertTrue

import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.junit.Assert.assertEquals
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class QuizServiceTest {

    @Autowired
    val quizService : QuizService?=null

    @Mock
    val quizRepository:QuizRepository?=null

    val quiz : Quiz = Quiz("Physics 12","This consist of class 12 Physic","100","10",false)

    @Test
    fun addQuizTest(){
        `when`(quizRepository?.save(quiz)).thenReturn(quiz)
        assertEquals(quiz,quizService?.addQuiz(quiz))
    }

    @Test
    fun updateQuizTest(){
        `when`(quizRepository?.save(quiz)).thenReturn(quiz)
        assertEquals(quiz,quizService?.addQuiz(quiz))
    }

    @Test
    fun getQuizTest(){
       val quiz1 = quizService?.addQuiz(quiz)
        assertEquals(quiz.getMaxMarks(),quiz1?.getMaxMarks())
    }

    @Test
    fun deleteQuizTest(){
        val quizId :String = "7476ed3d-2b58-11ec-b584-c5e58d286b93"
        assertEquals(Unit,quizService?.deleteQuiz(quizId))
    }

    @Test
    fun getActiveQuizzesTest(){
      var qu =  quizService?.getActiveQuizzes()?.size
        if (qu != null) {
            assertTrue(qu > 0)
        }
    }



}