package org.example.reactiveloadtest.mapper

import org.example.reactiveloadtest.model.Model
import org.example.reactiveloadtest.model.ModelRequest
import org.example.reactiveloadtest.model.ModelResponse
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface ModelMapper {

    @Mapping(target = "createdAt", expression = "java(new Date())")
    fun toModel(request: ModelRequest): Model

    fun toResponse(model: Model): ModelResponse
}