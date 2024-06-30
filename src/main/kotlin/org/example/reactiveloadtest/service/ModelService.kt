package org.example.reactiveloadtest.service

import org.example.reactiveloadtest.mapper.ModelMapper
import org.example.reactiveloadtest.model.ModelRequest
import org.example.reactiveloadtest.model.ModelResponse
import org.example.reactiveloadtest.repository.ModelRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

interface ModelService {

    fun create(request: ModelRequest): Mono<ModelResponse>

    fun fetchAll(): Flux<ModelResponse>
}

@Service
class DefaultModelService(
    private val repository: ModelRepository,
    private val mapper: ModelMapper
) : ModelService {

    override fun create(request: ModelRequest) =
        Mono.fromCallable { mapper.toModel(request) }
            .subscribeOn(Schedulers.boundedElastic())
            .flatMap { model ->
                repository.save(model)
                    .map { mapper.toResponse(it) }
            }

    override fun fetchAll() =
        repository.findAll()
            .map { mapper.toResponse(it) }
}