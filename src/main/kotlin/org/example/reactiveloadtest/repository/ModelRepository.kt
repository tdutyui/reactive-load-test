package org.example.reactiveloadtest.repository

import org.example.reactiveloadtest.model.Model
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ModelRepository : ReactiveCrudRepository<Model, Long> {
}