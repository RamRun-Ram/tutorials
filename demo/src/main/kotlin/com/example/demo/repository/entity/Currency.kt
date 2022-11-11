package com.example.demo.repository.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import kotlin.Long

@Entity
class Currency(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null, val code: String)