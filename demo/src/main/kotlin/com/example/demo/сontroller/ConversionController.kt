package com.example.demo.сontroller

import com.example.demo.service.ConvertationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/conversion")
class ConversionController(private val convertationService: ConvertationService) {

    @GetMapping("/update")
    fun update() {
        convertationService.update()
    }
}