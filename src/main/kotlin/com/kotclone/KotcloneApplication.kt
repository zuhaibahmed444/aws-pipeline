package com.kotclone


import com.kotclone.model.User
import com.kotclone.model.exam.Category
import com.kotclone.service.CategoryService
import com.kotclone.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
public open class KotcloneApplication :CommandLineRunner {
	override fun run(vararg args: String?) {

		println("Strating code")
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(KotcloneApplication::class.java, *args)
}
