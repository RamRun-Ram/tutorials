package com.example.demo.service

import com.example.demo.repository.CurrencyRepository
import com.example.demo.repository.entity.Currency
import org.springframework.stereotype.Service

@Service
class CurrencyService(private val currencyRepository: CurrencyRepository) {

    fun create(currency: Currency) {
        currencyRepository.save(currency)
    }
}