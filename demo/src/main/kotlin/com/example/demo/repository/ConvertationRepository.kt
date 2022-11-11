package com.example.demo.repository

import com.example.demo.repository.entity.Convertation
import org.springframework.data.jpa.repository.JpaRepository

interface ConvertationRepository : JpaRepository<Convertation, Long> {
    fun findAllByDomainId(id: Long): List<Convertation>
}