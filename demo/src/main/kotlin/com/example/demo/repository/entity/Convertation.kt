package com.example.demo.repository.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Convertation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val domainId: Long,
    val valueFirst: Double?,
    @ManyToOne
    val firstCurrency: Currency,
    val valueSecond: Double?,
    @ManyToOne
    val secondCurrency: Currency,
    val dateTime: LocalDateTime = LocalDateTime.now(),
)