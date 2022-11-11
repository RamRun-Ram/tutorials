package com.example.demo.сontroller

import com.example.demo.repository.entity.Convertation
import com.example.demo.repository.entity.Domain
import com.example.demo.service.DomainService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/domain")
class DomainController(private val domainService: DomainService) {

    @PostMapping("/create")
    fun create(@RequestBody domain: Domain): String {
        domainService.create(domain)
        return "Ok"
    }

    @GetMapping("/history/{id}")
    fun getHistoryConversionById(@PathVariable id: Long): List<Convertation> {
        return domainService.getHistoryConversionById(id)
    }
}