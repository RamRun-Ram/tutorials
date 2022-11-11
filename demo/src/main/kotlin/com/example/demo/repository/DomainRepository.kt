package com.example.demo.repository

import com.example.demo.repository.entity.Domain
import org.springframework.data.jpa.repository.JpaRepository

interface DomainRepository : JpaRepository<Domain, Long> {
}