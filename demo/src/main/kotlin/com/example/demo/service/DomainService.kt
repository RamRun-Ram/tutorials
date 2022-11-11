package com.example.demo.service

import com.example.demo.repository.ConvertationRepository
import com.example.demo.repository.DomainRepository
import com.example.demo.repository.entity.Convertation
import com.example.demo.repository.entity.Domain
import org.springframework.stereotype.Service

@Service
class DomainService(
    private val domainRepository: DomainRepository,
    private val convertationRepository: ConvertationRepository,
    private val convertationService: ConvertationService,
) {

    fun create(domain: Domain) {
        domainRepository.save(domain)
        convertationService.update()
    }

    fun getHistoryConversionById(id: Long): List<Convertation> {
        return convertationRepository.findAllByDomainId(id)
    }
}