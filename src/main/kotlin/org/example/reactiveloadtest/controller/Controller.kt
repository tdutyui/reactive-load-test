package org.example.reactiveloadtest.controller

import org.example.reactiveloadtest.model.ModelRequest
import org.example.reactiveloadtest.service.ModelService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(private val service: ModelService) {

    @PostMapping("/create")
    fun create(@RequestBody request: ModelRequest) = service.create(request)

    @GetMapping("/fetchAll")
    fun fetchAll() = service.fetchAll()
}