package com.kotclone.controller

import com.razorpay.RazorpayClient
import org.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/payment")
class PaymentController {

    @PostMapping("/")
    @Throws(Exception :: class)
    fun generatePayment(@RequestBody amount :String): ResponseEntity<*> {
        val price = amount.toInt()
        var razorpayClient = RazorpayClient("rzp_test_wkav2Zig8NcfbX","ajlSkJbLpjCoAGl1LMHZRwrP")
        var opt = JSONObject()
        opt.put("amount",price*100)
        opt.put("currency","INR")
        opt.put("receipt","txn_123610")

        //send request
        var ord = razorpayClient.Orders.create(opt).toString()
        println(ord)


        return ResponseEntity.ok(ord)
    }
}