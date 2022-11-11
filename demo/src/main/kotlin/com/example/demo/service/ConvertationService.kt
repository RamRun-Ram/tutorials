package com.example.demo.service

import com.example.demo.repository.ConvertationRepository
import com.example.demo.repository.DomainRepository
import com.example.demo.repository.entity.Convertation
import com.example.demo.repository.entity.Domain
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder

@Service
@EnableScheduling
class ConvertationService(private val convertationRepository: ConvertationRepository, private val domainRepository: DomainRepository) {

    @Scheduled(fixedDelay = 100000)
    fun update() {
        val listDomain: List<Domain> = domainRepository.findAll()
        listDomain.forEach { domain ->
            val priceSecond = exchange(domain)
            val conversion =
                Convertation(null, domain.id!!, domain.priceFirst, domain.currencyFirst, priceSecond, domain.currencySecond)
            val domainUpdate =
                Domain(domain.id, domain.name, domain.priceFirst, domain.currencyFirst, priceSecond, domain.currencySecond)
            domainRepository.save(domainUpdate)
            convertationRepository.save(conversion)
        }
    }

    fun exchange(domain: Domain): Double {
        val restTemplate = RestTemplateBuilder().rootUri("https://x-rates.com").build()
        val url = UriComponentsBuilder
            .fromPath("/calculator/")
            .queryParam("from", domain.currencyFirst.code)
            .queryParam("to", domain.currencySecond.code)
            .queryParam("amount", domain.priceFirst).toUriString()
        return parse(restTemplate.getForEntity(url, String::class.java).body!!)
    }

    fun parse(parseString: String): Double {
        val parseDocument: Document = Jsoup.parse(parseString)
        return parseDocument.body().getElementsByClass("ccOutputRslt").text()
            .replace(",", "")
            .split(" ")[0]
            .toDouble()
    }
}