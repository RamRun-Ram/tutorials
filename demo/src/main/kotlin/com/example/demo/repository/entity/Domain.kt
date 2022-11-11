package com.example.demo.repository.entity

import java.time.LocalDateTime
import javax.persistence.*
import kotlin.Long

@Entity
class Domain(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val priceFirst: Double?,
    @ManyToOne
    val currencyFirst: Currency,
//    val priceSecond: Double? = null,
//    @ManyToOne
//    val currencySecond: Currency,
    val dateTime: LocalDateTime = LocalDateTime.now(),
)