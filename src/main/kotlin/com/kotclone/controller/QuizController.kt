package com.kotclone.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotclone.model.exam.Category
import com.kotclone.model.exam.Quiz
import com.kotclone.service.QuizService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/quiz")
class QuizController(
    @Autowired
    private val quizService: QuizService
) {

    val mapper = ObjectMapper()

    //add quiz service
    @PostMapping("/")
    fun addquiz(@RequestBody quiz: Quiz?): String? {
        println(quiz?.toString())
        return mapper.writeValueAsString(ResponseEntity.ok(quizService.addQuiz(quiz)))
    }
    //update quiz
    @PutMapping("/")
    fun updatequiz(@RequestBody quiz: Quiz?): ResponseEntity<Quiz?> {
        return ResponseEntity.ok(quizService.updateQuiz(quiz))
    }

    //get quiz
    @GetMapping("/")
    fun quizzes(): ResponseEntity<*> {
        return ResponseEntity.ok(quizService.quizzes())
    }
    //get quiz
    @GetMapping("/count")
    fun quizzescount(): ResponseEntity<*> {
        return ResponseEntity.ok(quizService.quizzes()?.size)
    }

    //get single quiz
    @GetMapping("/{qid}")
    fun quiz(@PathVariable("qid") qid: String?): Quiz? {
        return quizService.getQuiz(qid)
    }
    //delete the quiz
    @DeleteMapping("/{qid}")
    fun deletequiz(@PathVariable("qid") qid: String?) {
        quizService.deleteQuiz(qid)
    }

    @GetMapping("/category/{cid}")
    fun getQuizzesOfCategory(@PathVariable("cid") cid: String?): List<Quiz?>? {
        val category = Category("","")
        if (cid != null) {
            category.setCid(cid)
        }
        return quizService.getQuizzesOfCategory(category)
    }

    @GetMapping("/active")
    fun getActiveQuizzes(): List<Quiz?>? {
        return quizService.getActiveQuizzes()
    }
    //get active quizzes of category
    @GetMapping("/category/active/{cid}")
    fun getActiveQuizzes(@PathVariable("cid") cid: String?): List<Quiz?>? {
        val category = Category("","")
        if (cid != null) {
            category.setCid(cid)
        }
        return quizService.getActiveQuizzesOfCategory(category)
    }
}