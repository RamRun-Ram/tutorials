package com.example.demo.repository

import com.example.demo.repository.entity.Currency
import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyRepository : JpaRepository<Currency, Long> {
}