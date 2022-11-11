package com.example.demo.сontroller

import com.example.demo.repository.entity.Currency
import com.example.demo.service.CurrencyService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/currency")
class CurrencyController(private val currencyService: CurrencyService) {

    @PostMapping("/create")
    fun create(@RequestBody currency: Currency): String {
        currencyService.create(currency)
        return "Ok"
    }
}