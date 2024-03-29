package com.kotclone.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotclone.config.JwtUtils
import com.kotclone.model.JwtRequest
import com.kotclone.model.JwtResponse
import com.kotclone.model.User
import com.kotclone.service.impl.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.security.Principal


@RestController
@CrossOrigin("*")
class AuthenticateController {
    val mapper = ObjectMapper()

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val userDetailsService: UserDetailsServiceImpl? = null

    @Autowired
    private val jwtUtils: JwtUtils? = null

    //generate token
    @PostMapping("/api/v1/generate-token")
    @Throws(Exception::class)
    fun generateToken(@RequestBody jwtRequest: JwtRequest): ResponseEntity<*> {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword())
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("User not found ")
        }
        /////////////authenticate
        val userDetails = userDetailsService!!.loadUserByUsername(jwtRequest.getUsername())
        val token = jwtUtils?.generateToken(userDetails)
        val userdetail = userDetailsService!!.loadUserByUsername(jwtRequest.getUsername())
        return ResponseEntity.ok(JwtResponse(token, userdetail))
    }

    @Throws(Exception::class)
    private fun authenticate(username: String?, password: String?) {
        try {
            authenticationManager?.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER DISABLED " + e.message)
        } catch (e: BadCredentialsException) {
            throw Exception("Invalid Credentials " + e.message)
        }
    }
    //return the details of current user
    @GetMapping("/api/v1/current-user")
    fun getCurrentUser(principal: Principal): String? {
        return mapper.writeValueAsString(userDetailsService?.loadUserByUsername(principal.name))
    }
}



